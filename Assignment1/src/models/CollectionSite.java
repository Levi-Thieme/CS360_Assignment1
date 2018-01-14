package models;

import java.util.ArrayList;
import java.util.Date;

public class CollectionSite {

	private int ID;
	private String name;
	private String location_description;
	private double latitude, longitude;
	private ArrayList<String> collectionHistory;
 	
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
