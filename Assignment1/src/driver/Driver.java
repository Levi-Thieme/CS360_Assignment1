package driver;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import models.SiteMap;
import views.ApplicationFrame;

public class Driver {
	
	public static void main(String[] args) {
		final SiteMap map = new SiteMap();

        ApplicationFrame frame = new ApplicationFrame(map);

        
        
	}
	
}
