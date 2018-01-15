package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.teamdev.jxmaps.Marker;

/**
 * The CollectionSite Class represents a water collection site and contains
 * accessor and mutator methods for ID, name, description, latitude, longitude, and update history.
 * @author Levi Thieme
 *
 */
public class CollectionSite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 999L;
	private int ID;
	private String name;
	private String location_description;
	private double latitude, longitude;
	private ArrayList<String> collectionHistory;
	private String updated;
	
	public CollectionSite(int id, String name, String location_description, double latitude, double longitude) {
		
		ID = id;
		this.name = name;
		this.location_description = location_description;
		this.latitude = latitude;
		this.longitude = longitude;
		collectionHistory = new ArrayList<String>();
		updated = "";

	}
	
	public CollectionSite() {
		
	}
	
	public void addDate(int day, String month, int year) {
		
		String newDate = month + " " + day + ", " + year; 
		collectionHistory.add(newDate);
	}
 	
	public ArrayList<String> getCollectionHistory() {
		return collectionHistory;
	}

	public void setCollectionHistory(ArrayList<String> collectionHistory) {
		this.collectionHistory = collectionHistory;
	}


	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation_description() {
		return location_description;
	}

	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	
	public void getHistory() {
		
		for(int i= 0; i<collectionHistory.size();i++) {
			System.out.println(collectionHistory.get(i));
		}
	}
}
