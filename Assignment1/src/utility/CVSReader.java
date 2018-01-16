package utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import models.CollectionSite;

public class CVSReader {
	
	public static ArrayList<CollectionSite> readCollectionSitesFromFile() {
		
		ArrayList<CollectionSite> sites = new ArrayList<CollectionSite>();
		
		JFileChooser fc = new JFileChooser();
		
		int returnVal = fc.showOpenDialog(null);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				String line = br.readLine();
			
				
				while((line = br.readLine()) != null) {
					String[] attributes = line.split(",");
					
					
					CollectionSite site = createSite(attributes);
					
					sites.add(site);
					
					
				
				}
				
				fr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return sites;
	}
	
	public static ArrayList<CollectionSite> readInitialSites() {
		
		ArrayList<CollectionSite> sites = new ArrayList<CollectionSite>();
		File file = new File("sample-sites.csv");
			
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				String line = br.readLine();
			
				
				while((line = br.readLine()) != null) {
					String[] attributes = line.split(",");
					
					
					CollectionSite site = createSite(attributes);
					
					sites.add(site);
					
					
				
				}
				
				fr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		
			return sites;
	}
	
	private static CollectionSite createSite(String[] data) {
		String num = data[0];
		double longitude = Double.parseDouble(data[1]);
		double latitude = Double.parseDouble(data[2]);
		String description = data[3];
		String name = data[4];
		
		return new CollectionSite(num, name, description, latitude, longitude);
	}

}
