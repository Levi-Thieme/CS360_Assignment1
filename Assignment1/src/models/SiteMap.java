package models;

import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapMouseEvent;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.MouseEvent;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.swing.MapView;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SiteMap extends MapView{
	private ArrayList<Marker> markers;
	
	public SiteMap(ArrayList<CollectionSite> sites, DefaultListModel<Marker> listMarkers) {
		
		
		markers = new ArrayList<Marker>();
		
		
		// Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    // Creating a map options object
                    MapOptions options = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    options.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(options);
                    // Setting the map center
                    map.setCenter(new LatLng(42.1142063, -86.4883564));
                    // Setting initial zoom value
                    map.setZoom(8.0);
                    
                    for(int i = 0; i < sites.size(); i++) {
                    	Marker siteMarker = new Marker(map);
                    	
                    	CollectionSite site = sites.get(i);
                    	
                    	siteMarker.setTitle(site.getName());
                    	siteMarker.setPosition(new LatLng(site.getLatitude(), site.getLongitude()));
                    	
                    	listMarkers.addElement(siteMarker);
                    }
                    
                    
                }
            }
        });
    }
	
	
	public ArrayList<Marker> getMarkers(){
		return markers;
	}
}
