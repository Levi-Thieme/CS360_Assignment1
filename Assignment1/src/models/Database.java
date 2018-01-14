package models;

import java.util.ArrayList;

/**
 * The Database Class stores the Watershed Objects
 * @author Levi Thieme
 *
 */
public class Database {
	private ArrayList<CollectionSite> entries;
	
	public Database(ArrayList<CollectionSite> sites) {
		entries = sites;
	}
	
	public ArrayList<CollectionSite> getEntries() {
		return entries;
	}
	
	public void setEntries(ArrayList<CollectionSite> entries) {
		this.entries = entries;
	}
	
	
	public CollectionSite getSite(String name) {
		for(int i = 0; i < entries.size(); i++) {
			if(name.equals(entries.get(i)))
				return entries.get(i);
		}
		return null;
	}
	
	
	
}
