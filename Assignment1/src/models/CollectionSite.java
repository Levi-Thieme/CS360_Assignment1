package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.teamdev.jxmaps.Marker;

/**
 * The CollectionSite Class represents a water collection site and contains
 * accessor and mutator methods for ID, name, description, latitude, longitude, and update history.
 * @author Levi Thieme
 *
 */
public class CollectionSite implements Serializable{

	private static final long serialVersionUID = 999L;
	private String num;
	private String name;
	private String location_description;
	private double latitude, longitude;
	private ArrayList<Date> collectionHistory;
	private Date updated;
	private String time;
	private String updatedBy;
	
	

	public CollectionSite(String num, String name, String location_description, double latitude, double longitude) {
		
		this.num = num;
		this.name = name;
		this.location_description = location_description;
		this.latitude = latitude;
		this.longitude = longitude;
		collectionHistory = new ArrayList<Date>();
		updated = null;
		time = "";
		updatedBy = "";

	}
	
	
	public void addDate(Date updatedOn) {
		
		collectionHistory.add(updatedOn);
	}
 	


	public ArrayList<Date> getCollectionHistory() {
		return collectionHistory;
	}

	public void setCollectionHistory(ArrayList<Date> collectionHistory) {
		this.collectionHistory = collectionHistory;
	}



	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public void setUpdated(String updated) {
		
		
		
		DateFormat shortDF = DateFormat.getDateInstance(DateFormat.SHORT);
		
		try {
			Date date = shortDF.parse(updated);
			
			
			if(date.equals(this.updated))
				return;
			
			
			collectionHistory.add(date);
			this.updated = date;
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Improper date format. Enter the date in the format MM/DD/YYYY");
		}
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	


	public void getHistory() {
		
		for(int i= 0; i<collectionHistory.size();i++) {
			System.out.println(collectionHistory.get(i));
		}
	}
}
