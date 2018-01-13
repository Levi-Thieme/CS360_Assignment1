package models;

import java.util.ArrayList;

/**
 * The Database Class stores the Watershed Objects
 * @author Levi Thieme
 *
 */
public class Database {
	private ArrayList<CollectionSite>[] entries;
	
	private int rows;
	private static final String[] columnNames = {"ID",
            "Name",
            "Latitude",
            "Longitude",
            "Updated",
            "Description"};
	private static final int columns = columnNames.length;
	
	
	public ArrayList<CollectionSite>[] getEntries() {
		return entries;
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public String[] getColumnNames() {
		return columnNames;
	}
	
}
