package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.LocalRequest;
import util.CommonConstants;
import util.CommonUtil;
import util.DBConnectionUtil;
import util.QueryUtil;


public class LocalRequestServiceImp implements ILocalRequestService {
	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(LocalRequestServiceImp.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createLocalRequestTable();
	}

	private PreparedStatement preparedStatement;

	/**
	 * This method initially drop existing LocalRequests table in the database and
	 * recreate table structure to insert localRequest entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 */
	public static void createLocalRequestTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new localRequests table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add set of localRequests for as a batch from the selected localRequest List
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * 
	 */
	@Override
	public void addLocalRequest(LocalRequest localRequest) {

		String localRequestID = CommonUtil.generateIDs(getLocalRequestIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in LocalRequestQuery.xml file and use
			 * insert_localRequest key to extract value of it
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_LOCALREQUESTS));
			connection.setAutoCommit(false);
			
			//Generate localRequest IDs
			localRequest.setLocalRequestCompanyID(localRequestID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, localRequest.getLocalRequestCompanyID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, localRequest.getLocalRequestCompanyName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, localRequest.getLocalRequestCompanyAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, localRequest.getLocalRequestCompanyEmail());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, localRequest.getLocalRequestCompanyFax());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, localRequest.getLocalRequestCompanyMobile());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, localRequest.getLocalRequestCompanyOffice1());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, localRequest.getLocalRequestCompanyOffice2());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, localRequest.getLocalRequestCompanyTeaType());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, localRequest.getLocalRequestCompanyQuntity());
			// Add localRequest
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * LocalRequest details can be retrieved based on the provided localRequest ID
	 * 
	 * @param localRequestID
	 *            - LocalRequest details are filtered based on the ID
	 * 
	 * @see #actionOnLocalRequest()
	 */
	@Override
	public LocalRequest getLocalRequestByID(String localRequestID) {

		return actionOnLocalRequest(localRequestID).get(0);
	}
	
	/**
	 * Get all list of localRequests
	 * 
	 * @return ArrayList<LocalRequest> 
	 * 						- Array of localRequest list will be return
	 * 
	 * @see #actionOnLocalRequest()
	 */
	@Override
	public ArrayList<LocalRequest> getLocalRequests() {
		
		return actionOnLocalRequest(null);
	}

	/**
	 * This method delete an localRequest based on the provided ID
	 * 
	 * @param localRequestID
	 *            - Delete localRequest according to the filtered localRequest details
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	@Override
	public void removeLocalRequest(String localRequestID) {

		// Before deleting check whether localRequest ID is available
		if (localRequestID != null && !localRequestID.isEmpty()) {
			/*
			 * Remove localRequest query will be retrieved from LocalRequestQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_LOCALREQUEST));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, localRequestID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET localRequest by ID and Display all localRequests
	 * 
	 * @param localRequestID
	 *            ID of the localRequest to remove or select from the list

	 * @return ArrayList<LocalRequest> Array of localRequest list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getLocalRequests()
	 * @see #getLocalRequestByID(String)
	 */
	private ArrayList<LocalRequest> actionOnLocalRequest(String localRequestID) {

		ArrayList<LocalRequest> localRequestList = new ArrayList<LocalRequest>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching localRequest it checks whether localRequest ID is
			 * available
			 */
			if (localRequestID != null && !localRequestID.isEmpty()) {
				/*
				 * Get localRequest by ID query will be retrieved from
				 * LocalRequestQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LOCALREQUEST));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, localRequestID);
			}
			/*
			 * If localRequest ID is not provided for get localRequest option it display
			 * all localRequests
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_LOCALREQUESTS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LocalRequest localRequest = new LocalRequest();
				localRequest.setLocalRequestCompanyID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				localRequest.setLocalRequestCompanyName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				localRequest.setLocalRequestCompanyAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				localRequest.setLocalRequestCompanyEmail(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				localRequest.setLocalRequestCompanyFax(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				localRequest.setLocalRequestCompanyMobile(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				localRequest.setLocalRequestCompanyOffice1(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				localRequest.setLocalRequestCompanyOffice2(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				localRequest.setLocalRequestCompanyTeaType(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				localRequest.setLocalRequestCompanyQuntity(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				localRequestList.add(localRequest);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return localRequestList;
	}

	/**
	 * Get the updated localRequest
	 * 
	 * @param localRequestID
	 *            ID of the localRequest to remove or select from the list
	 * 
	 * @return return the LocalRequest object
	 * 
	 */
	@Override
	public LocalRequest updateLocalRequest(String localRequestID, LocalRequest localRequest) {

		/*
		 * Before fetching localRequest it checks whether localRequest ID is available
		 */
		if (localRequestID != null && !localRequestID.isEmpty()) {
			/*
			 * Update localRequest query will be retrieved from LocalRequestQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_LOCALREQUEST));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, localRequest.getLocalRequestCompanyName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, localRequest.getLocalRequestCompanyAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, localRequest.getLocalRequestCompanyEmail());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, localRequest.getLocalRequestCompanyFax());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, localRequest.getLocalRequestCompanyMobile());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, localRequest.getLocalRequestCompanyOffice1());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, localRequest.getLocalRequestCompanyOffice2());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, localRequest.getLocalRequestCompanyTeaType());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, localRequest.getLocalRequestCompanyQuntity());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, localRequest.getLocalRequestCompanyID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated localRequest
		return getLocalRequestByID(localRequestID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of localRequest id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	private ArrayList<String> getLocalRequestIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of localRequest IDs will be retrieved from LocalRequestQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LOCALREQUEST_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
