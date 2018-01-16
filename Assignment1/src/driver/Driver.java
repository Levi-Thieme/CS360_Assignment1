package driver;

import java.io.*;
import controllers.ApplicationController;
import models.Database;
import utility.CVSReader;

public class Driver {
	private static final String defaultSaveLoadFile = "entries";
	
	public static void main(String[] args) throws IOException {
		Database siteDB = new Database(defaultSaveLoadFile);
					
		ApplicationController controller = new ApplicationController(siteDB);
        
	}
	
}
