package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import models.SiteMap;
import views.ApplicationFrame;

public class ApplicationController implements MouseListener, ActionListener{

	ApplicationFrame appView;
	SiteMap sm = new SiteMap();
	
	public ApplicationController() {
		appView = new ApplicationFrame(sm);
		
		
	
		appView.getMntmAddSite().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Need to handle all of the ApplicationFrame's menuItems and buttons in this
		 */
		if(arg0.getActionCommand().equals("Save")) { // Saves the state of the window, and the data currently showing
			
			appView.getMntmSave().addActionListener(this);
		}
		else if(arg0.getActionCommand().equals("Exit")) { //Closes Program, but prompts user to make sure they have saved
			/*if( user hasn't saved before exiting){
			*		{prompt user, asking them if they want to save}
			*else {
			*/
			System.exit(0);
			appView.getMntmExit().addActionListener(this);
		}
		else if(arg0.getActionCommand().equals("Add Site")) {
			
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
