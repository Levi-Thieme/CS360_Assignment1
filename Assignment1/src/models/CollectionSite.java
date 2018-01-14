package models;

import java.util.ArrayList;
import java.util.Date;

public class CollectionSite {

	private int ID;
	private String name;
	private String location_description;
	private double latitude, longitude;
<<<<<<< HEAD
	private ArrayList<String> collectionHistory;
 	
=======
	Date updated = new Date();
	
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

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

>>>>>>> branch 'master' of https://github.com/Levi-Thieme/CS360_Assignment1.git
	public CollectionSite(int id, String n, String location_description, double lat, double longitude) {
		
		ID = id;
		name = n;
		this.location_description = location_description;
		latitude = lat;
		this.longitude = longitude;
		
		

	}
	
	public void addDate(int day, String month, int year) {
		
		String newDate = month + " " + day + ", " + year; 
		collectionHistory.add(newDate);
	}
	public void getHistory() {
		
		for(int i= 0; i<collectionHistory.size();i++) {
			System.out.println(collectionHistory.get(i));
		}
	}
}
