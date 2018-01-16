package models;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import utility.CVSReader;

/**
 * The Database Class stores the CollectionSite Objects and
 * provides methods for loading and saving objects to a file
 * @author Levi Thieme
 *
 */
public class Database {
	private String filename;
	private ArrayList<CollectionSite> entries;
	
	
	/**
	 * Database constructor. Loads CollectionSite objects from file
	 * @param filename The name of the file from which to load and save CollectionSite objects
	 */
	public Database(String filename) {
		this.filename = filename;
		entries = new ArrayList<CollectionSite>();
		
		load();
	}
	
	/**
	 * Adds a site to the entries list
	 * @param siteToAdd The CollectionSite to be added
	 */
	public void addSite(CollectionSite siteToAdd) {
		
		//Handle duplicate sites
		CollectionSite existingSite = getSiteByName(siteToAdd.getName());
		
		if(existingSite  != null) {
			String ObjButtons[] = {"Yes", "No"};
			int promptResult;
			
			promptResult = JOptionPane.showOptionDialog(null, "The following site: " + siteToAdd.getName() + " already exists. Would you like to overwrite it?",
					null, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
			
			if(promptResult == JOptionPane.YES_OPTION) {
				int index = -1;
				for(index = 0; index < entries.size(); index++) {
					if(entries.get(index).getName().equals(existingSite.getName()))
						break;
				}
				
				entries.remove(index);
				entries.add(siteToAdd);
			}
			else {
				return;
			}
		}
		
		entries.add(siteToAdd);
	}
	
	
	/**
	 * Saves the entries to a file
	 */
	public void save() {
		try {
			FileOutputStream fOut = new FileOutputStream(filename);
			ObjectOutputStream outputStream = new ObjectOutputStream(fOut);
			
			for(int i = 0; i < entries.size(); i++)
				outputStream.writeObject(entries.get(i));
			
			outputStream.close();
			fOut.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	
	/**
	 * Loads the entries from the specified file
	 * @param filename Name of the file from which to load the entries
	 */
	public void load() {
		boolean eof = false;
		
		try {
			FileInputStream fInput = new FileInputStream(filename);
			ObjectInputStream inputStream = new ObjectInputStream(fInput);
			
			
			while(!eof) {
				CollectionSite site = (CollectionSite) inputStream.readObject();
				entries.add(site);	
				}
			
			inputStream.close();
			fInput.close();
			
			
		} catch(EOFException e) {
			eof = true;
		}
		catch(FileNotFoundException e) {
			entries = CVSReader.readInitialSites();
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a reference to a CollectionSite
	 * @param name The name of the CollectionSite
	 * @return A reference to a CollectionSite specified by name
	 */
	public CollectionSite getSiteByName(String name) {
		for(int i = 0; i < entries.size(); i++) {
			if(name.equals(entries.get(i).getName()))
				return entries.get(i);
		}
		return null;
	}
	
	
	
	/**
	 * 
	 * @return A reference to the entries ArrayList<CollectionSite>
	 */
	public ArrayList<CollectionSite> getEntries() {
		return entries;
	}
	
	public void setEntries(ArrayList<CollectionSite> entries) {
		this.entries = entries;
	}
	
	
	
	
	
}
