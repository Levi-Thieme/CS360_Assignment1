package controllers;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapMouseEvent;

import models.CollectionSite;

import com.teamdev.jxmaps.Marker;

import models.CollectionSite;
import models.Database;
import models.SiteMap;
import utility.CVSReader;
import views.ApplicationFrame;

public class ApplicationController implements ActionListener, ListSelectionListener{

	ApplicationFrame appView;
	SiteMap sm;
	Database siteDB;
	DefaultListModel<String> siteListModel;
	String selectedMarker;
	boolean changesSaved = true;
	
	public ApplicationController(Database siteDB) {
		
		this.siteDB = siteDB;
		ArrayList<CollectionSite> sites = siteDB.getEntries();
		siteListModel = new DefaultListModel<String>();
		
		for(int i = 0; i < sites.size(); i++)
			siteListModel.addElement(sites.get(i).getName());
		
		sm = new SiteMap(sites);
		
		
 		appView = new ApplicationFrame(sm, siteListModel);

		
		appView.getMntmAddSite().addActionListener(this);
		appView.getMntmExit().addActionListener(this);
		appView.getMntmSave().addActionListener(this);
		appView.getBtnEdit().addActionListener(this);
		appView.getBtnDelete().addActionListener(this);
		appView.getBtnViewHistory().addActionListener(this);
		appView.getMarkerList().addListSelectionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getActionCommand().equals("Upload")) {
			ArrayList<CollectionSite> uploadedSites = CVSReader.readCollectionSitesFromFile();
			
			for(int i = 0; i < uploadedSites.size(); i++)
				siteDB.addSite(uploadedSites.get(i));
			
		}
		/*
		 * Need to handle all of the ApplicationFrame's menuItems and buttons in this
		 */
		if(arg0.getActionCommand().equals("Save")) { // Saves the state of the window, and the data currently showing
			
			siteDB.save();
		}
		else if(arg0.getActionCommand().equals("Exit"))
		{ //Closes Program, but prompts user to make sure they have saved

			
			String ObjButtons[] = {"Yes", "No"};
			int promptResult;
			
			if(!changesSaved) {
				promptResult = JOptionPane.showOptionDialog(appView, "Changes have been made that are not saved. Would you like to exit without saving your changes?",
						null, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
				
				if(promptResult == JOptionPane.YES_OPTION) {
					siteDB.save();
					System.exit(0);
				}	
			}
			else {
			
				promptResult = JOptionPane.showOptionDialog(appView, "Are you sure you want to exit?",
						null, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, ObjButtons,ObjButtons[1]);
				
				if(promptResult==JOptionPane.YES_OPTION)
				{
					siteDB.save();
					System.exit(0);
				}
			}

		}
		else if(arg0.getActionCommand().equals("Add Site")) {
			//get user input, create the collectionsite, update database, update view
			
			
		}
		else if(arg0.getActionCommand().equals("Edit")) {
			appView.getNameField().setEditable(true);
			appView.getNumField().setEditable(true);
			appView.getLongField().setEditable(true);
			appView.getLatField().setEditable(true);
			appView.getDateField().setEditable(true);
			appView.getTimeField().setEditable(true);
			appView.getUpdatedByField().setEditable(true);
			appView.getDescriptionPane().setEditable(true);
		
			
			//Convert "Edit" button to "Save Changes" button
			JButton editBtn = (JButton)arg0.getSource();
			editBtn.setText("Save Changes");
			
			changesSaved = false;
		}
		
		else if(arg0.getActionCommand().equals("Save Changes")) {
			//Convert "Save Changes" button to "Edit" button
			JButton editBtn = (JButton)arg0.getSource();
			editBtn.setText("Edit");
			
			saveTextFieldChanges();
			
			
			appView.getNameField().setEditable(false);
			appView.getNumField().setEditable(false);
			appView.getLongField().setEditable(false);
			appView.getLatField().setEditable(false);
			appView.getDateField().setEditable(false);
			appView.getTimeField().setEditable(false);
			appView.getUpdatedByField().setEditable(false);
			appView.getDescriptionPane().setEditable(false);
			
			changesSaved = true;
		}
		else if(arg0.getActionCommand().equals("View Update History")) {
			JFrame historyFrame = new JFrame();
			historyFrame.setSize(new Dimension(600, 500));
			
			JTextPane historyPane = new JTextPane();
			historyFrame.add(historyPane);
			
			CollectionSite selectedSite = siteDB.getSiteByName(selectedMarker);
			
			String updateHistory = "";
			SimpleDateFormat dateFormatter = new SimpleDateFormat("M-d-y");
			
			for(int i = 0; i < selectedSite.getCollectionHistory().size(); i++) {
				updateHistory = dateFormatter.format(selectedSite.getCollectionHistory().get(i)) + "\n" + updateHistory;
			}
			
			historyPane.setText(updateHistory);
			
			historyFrame.setVisible(true);
		}
	}

	
	
	/**
	 * Saves the changes to the TextFields to the selected object
	 */
	public void saveTextFieldChanges() {
		//Getting the CollectionSite Object that corresponds to the selected Marker
		CollectionSite changedSite = siteDB.getSiteByName(selectedMarker);
		
		changedSite.setName(appView.getNameField().getText());
		changedSite.setNum(appView.getNumField().getText());
		changedSite.setLatitude(Double.parseDouble(appView.getLatField().getText()));
		changedSite.setLongitude(Double.parseDouble(appView.getLongField().getText()));
		changedSite.setLocation_description(appView.getDescriptionPane().getText());
		
		changedSite.setUpdated(appView.dateField().getText());
		changedSite.setTime(appView.getTimeField().getText());
		changedSite.setUpdatedBy(appView.getUpdatedByField().getText());
		
		
		
	}


	/**
	 * Display the corresponding site's info to the info panel and update map view
	 * @param source
	 */
	private void displayInfo(String name) {
		CollectionSite siteToDisplay = siteDB.getSiteByName(name);
		
		

		
		if(siteToDisplay == null)
			return;
		
		appView.getNameField().setText(name);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("M-d-y");
		
		
		appView.getNameField().setText(siteToDisplay.getName());
		appView.getNumField().setText(String.valueOf(siteToDisplay.getNum()));
		appView.getLongField().setText(String.valueOf(siteToDisplay.getLongitude()));
		appView.getLatField().setText(String.valueOf(siteToDisplay.getLatitude())); 
		
		if(siteToDisplay.getUpdated() == null)
			appView.dateField().setText("");
		else
			appView.dateField().setText(dateFormatter.format(siteToDisplay.getUpdated()));
		
		appView.getTimeField().setText(siteToDisplay.getTime());
		appView.getUpdatedByField().setText(siteToDisplay.getUpdatedBy());
		appView.getDescriptionPane().setText(siteToDisplay.getLocation_description());
		
		sm.getMap().setCenter(new LatLng(siteToDisplay.getLatitude(), siteToDisplay.getLongitude()));
		sm.getMap().setZoom(14.0);
	}




	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(changesSaved) {
			JList<String> list = (JList<String>) e.getSource();
			selectedMarker = list.getSelectedValue();
			
			displayInfo(selectedMarker);
			
		}
		else {
			JOptionPane.showMessageDialog(appView, "Save your changes before selecting another site");
		}
	}
	
	
	
	

}
