package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import service.ILocalRequestService;


public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ILocalRequestService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.LOCALREQUEST_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.LOCALREQUEST_ID_PREFIX + next;
		}
		return id;
	}

	
	public static final Logger log1 = Logger.getLogger(ILocalRequestService.class.getName());

	public static final Properties properties1 = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log1.log(Level.SEVERE, e.getMessage());
		}
	}

	public static String generateSignUpIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.SIGNUP_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.SIGNUP_ID_PREFIX + next;
		}
		return id;
	}
	
	public static final Logger log2 = Logger.getLogger(ILocalRequestService.class.getName());

	public static final Properties properties2 = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			log1.log(Level.SEVERE, e.getMessage());
		}
	}

	public static String generateBIDIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.BID_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.BID_ID_PREFIX + next;
		}
		return id;
	}
}
