package controllers;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.teamdev.jxmaps.Marker;

import models.CollectionSite;
import models.Database;
import models.SiteMap;
import views.ApplicationFrame;

public class ApplicationController implements MouseListener, ActionListener{

	ApplicationFrame appView;
	SiteMap sm = new SiteMap();
	Database sites;
	
	public ApplicationController() {
		appView = new ApplicationFrame(sm);
		
		appView.getMntmAddSite().addActionListener(this);
		appView.getMntmExit().addActionListener(this);
		appView.getMntmSave().addActionListener(this);
		appView.getBtnEdit().addActionListener(this);
		appView.getBtnDelete().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Need to handle all of the ApplicationFrame's menuItems and buttons in this
		 */
		if(arg0.getActionCommand().equals("Save")) { // Saves the state of the window, and the data currently showing
			
		}
		else if(arg0.getActionCommand().equals("Exit"))
		{ //Closes Program, but prompts user to make sure they have saved

			/*if( user hasn't saved before exiting){
			*		{prompt user, asking them if they want to save}
			*else {
		
			*/
			String ObjButtons[] = {"Yes", "No"};
			int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?",
					null, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, ObjButtons,
					ObjButtons[1]);
			if(PromptResult==JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}

		}
		if(arg0.getActionCommand().equals("Add Site")) {
			
			
		}
		if(arg0.getActionCommand().equals("Edit")) {
			appView.getNameField().setEditable(true);
			appView.getNumField().setEditable(true);
			appView.getLongField().setEditable(true);
			appView.getLatField().setEditable(true);
			appView.getUpdatedField().setEditable(true);
			appView.getDescriptionPane().setEditable(true);
			
		}
	}

	/**
	 * Handles marker clicks
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		 * Check if e.getSource() is an instanceof Marker
		 * If so, pass e.getSource to the displayInfo() method
		 */
		if(e.getSource() instanceof Marker) {
			displayInfo((Marker) e.getSource());
		}
	}

	/**
	 * Display the corresponding site's info to the info panel
	 * @param source
	 */
	private void displayInfo(Marker source) {
		CollectionSite siteToDisplay = sites.getSite(source.getTitle());
		
		if(siteToDisplay == null)
			return;
		
		appView.getNameField().setText(siteToDisplay.getName());
		appView.getNumField().setText(String.valueOf(siteToDisplay.getID()));
		appView.getLongField().setText(String.valueOf(siteToDisplay.getLongitude()));
		appView.getLatField().setText(String.valueOf(siteToDisplay.getLatitude()));
		appView.getUpdatedField().setText(siteToDisplay.getUpdated().toString());
		appView.getDescriptionPane().setText(siteToDisplay.getLocation_description());
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
