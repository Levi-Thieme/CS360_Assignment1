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
		
		
		appView.get
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Need to handle all of the ApplicationFrame's menuItems and buttons in this
		 */
		
		
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
