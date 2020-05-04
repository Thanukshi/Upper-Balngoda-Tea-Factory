/**
 * 
 */
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


import util.CommonConstants;
import util.CommonUtil;
import util.DBConnectionUtil;
import util.QueryUtil;

import model.SignUp;

/**
 * @author thanu
 *
 */
public class SignUpServiceImp implements ISignUpService {

	/** Initialize logger */
	public static final Logger log1 = Logger.getLogger(SignUpServiceImp.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		//create table or drop if exist
		createSignUpTable();
	}

	private PreparedStatement preparedStatement;

	
	public static void createSignUpTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			//statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new employees table as per SQL query available in
			// Query.xml
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_SIGNUP_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
		}
	}

	
	@Override
	public void addSignUp(SignUp signUp) {

		String signUpID = CommonUtil.generateSignUpIDs(getSignUpIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_SIGNUP));
			connection.setAutoCommit(false);
			
			//Generate signUp IDs
			signUp.setCompanyID(signUpID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_ONE, signUp.getCompanyID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_TWO, signUp.getCompanyType());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_THREE, signUp.getCompanyName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_FOUR, signUp.getUserName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_FIVE, signUp.getCompanyPassword());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_SIX, signUp.getCompanyRePassword());

			// Add signUp
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
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
				log1.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	
	@Override
	public SignUp getSignUpByID(String signUpID) {

		return actionOnSignUp(signUpID).get(0);
	}
	
	/**
	 * Get all list of signUp
	 * 
	 * @return ArrayList<SignUp> 
	 * 						- Array of signUp list will be return
	 * 
	 * @see #actionOnSignUp()
	 */
	@Override
	public ArrayList<SignUp> getSignUp() {
		
		return actionOnSignUp(null);
	}

	
	@Override
	public void removeSignUp(String signUpID) {

		// Before deleting check whether signUp ID is available
		if (signUpID != null && !signUpID.isEmpty()) {
			/*
			 * Remove signUp query will be retrieved from SignUpQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_SIGNUP));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_ONE, signUpID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log1.log(Level.SEVERE, e.getMessage());
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
					log1.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	
	private ArrayList<SignUp> actionOnSignUp(String signUpID) {

		ArrayList<SignUp> signUpList = new ArrayList<SignUp>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether signUp ID is
			 * available
			 */
			if (signUpID != null && !signUpID.isEmpty()) {
				/*
				 * Get signUp by ID query will be retrieved from
				 * SignUpQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SIGNUP));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_ONE, signUpID);
			}
			/*
			 * If signUp ID is not provided for getsignUp option it display
			 * all signUp
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_SIGNUP));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				SignUp signUp = new SignUp();
				signUp.setCompanyID(resultSet.getString(CommonConstants.COLUMN_INDEX_SIGNUP_ONE));
				signUp.setCompanyType(resultSet.getString(CommonConstants.COLUMN_INDEX_SIGNUP_TWO));
				signUp.setCompanyName(resultSet.getString(CommonConstants.COLUMN_INDEX_SIGNUP_THREE));
				signUp.setUserName(resultSet.getString(CommonConstants.COLUMN_INDEX_SIGNUP_FOUR));
				signUp.setCompanyPassword(resultSet.getString(CommonConstants.COLUMN_INDEX_SIGNUP_FIVE));
				signUp.setCompanyRePassword(resultSet.getString(CommonConstants.COLUMN_INDEX_SIGNUP_SIX));
				signUpList.add(signUp);
				
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
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
				log1.log(Level.SEVERE, e.getMessage());
			}
		}
		return signUpList;
	}

	
	
	@Override
	public SignUp updateSignUp(String signUpID, SignUp signUp) {

		/*
		 * Before fetching employee it checks whether signUp ID is available
		 */
		if (signUpID != null && !signUpID.isEmpty()) {
			/*
			 * Update signUp query will be retrieved from SignUpQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_SIGNUP));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_ONE, signUp.getCompanyType());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_TWO, signUp.getCompanyName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_THREE, signUp.getUserName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_FOUR, signUp.getCompanyPassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_FIVE, signUp.getCompanyRePassword());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIGNUP_SIX, signUp.getCompanyID());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log1.log(Level.SEVERE, e.getMessage());
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
					log1.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated signUp
		return getSignUpByID(signUpID);
	}
	


	private ArrayList<String> getSignUpIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of signUp IDs will be retrieved from SignUpQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SIGNUP_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_SIGNUP_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log1.log(Level.SEVERE, e.getMessage());
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
				log1.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
