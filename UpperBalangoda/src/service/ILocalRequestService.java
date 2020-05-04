/**
 * OOP 2018
 * 
 * @author Udara Samaratunge  Department of Software Engineering, SLIIT 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
package service;

import model.LocalRequest;

import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * Contract for the implementation of LocalRequest Service .
 * 
 * @author Udara Samaratunge, SLIIT
 * @version 1.0
 */
public interface ILocalRequestService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ILocalRequestService.class.getName());


	/**
	 * AddlocalRequests forlocalRequest table
	 * @paramlocalRequest
	 */
	public void addLocalRequest(LocalRequest localRequest);

	/**
	 * Get a particular LocalRequest
	 * 
	 * @param empoyeeID
	 * @return LocalRequest
	 */
	public LocalRequest getLocalRequestByID(String localRequestID);
	
	/**
	 * Get all list oflocalRequests
	 * 
	 * @return ArrayList<LocalRequest>
	 */
	public ArrayList<LocalRequest> getLocalRequests();
	
	/**
	 * Update existinglocalRequest
	 * @paramlocalRequestID
	 * @paramlocalRequest
	 * 
	 * @return
	 */
	public LocalRequest updateLocalRequest(String localRequestID, LocalRequest localRequest);

	/**
	 * Remove existinglocalRequest
	 * 
	 * @paramlocalRequestID
	 */
	public void removeLocalRequest(String localRequestID);

}
