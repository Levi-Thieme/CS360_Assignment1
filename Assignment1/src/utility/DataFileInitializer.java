package utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.CollectionSite;

/**
 * The DataFileInitializer Class is used to initialize a data file containing
 * serialized CollectionSite Objects
 * @author Levi Thieme
 *
 */
public class DataFileInitializer {
	
	
	public static void initializeSiteDataFile(String filename) {
		
		try {
			FileOutputStream fOut = new FileOutputStream("entries");
			ObjectOutputStream out = new ObjectOutputStream(fOut);
			
			ArrayList<CollectionSite> sites = new ArrayList<>();
			
			sites.add(new CollectionSite(100, "Cedar Creek", "Tonkel Road", 41.218589, -85.076772));
			sites.add(new CollectionSite(101, "Willow Creek", "Coldwater Road", 41.249419, -85.134522));
			sites.add(new CollectionSite(102, "Black Creek", "DeKalb CR 7A", 41.2843, -85.1401));
			
			for(int i = 0; i < sites.size(); i++)
				out.writeObject(sites.get(i));
			
			out.close();
			fOut.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
