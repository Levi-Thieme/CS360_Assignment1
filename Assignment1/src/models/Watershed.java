package models;

import java.util.Date;

public class Watershed {

	private int ID;
	private String name;
	private String location_description;
	private double latitude, longitude;
	Date updated = new Date();
	
	public Watershed(int id, String n, String location_description, double lat, double longitude) {
		
		ID = id;
		name = n;
		this.location_description = location_description;
		latitude = lat;
		this.longitude = longitude;
		updated.getTime();
	}
}
