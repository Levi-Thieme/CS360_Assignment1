package driver;

import java.awt.BorderLayout;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controllers.ApplicationController;
import models.CollectionSite;
import models.Database;
import models.SiteMap;
import utility.DataFileInitializer;
import views.ApplicationFrame;

public class Driver {
	
	public static void main(String[] args) throws IOException {
		
		Database siteDB = new Database("entries");
			
		ApplicationController controller = new ApplicationController(siteDB);
        
	}
	
}
