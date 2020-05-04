/**
 * 
 */
package service;

import java.util.ArrayList;
import java.util.logging.Logger;

import model.SignUp;


public interface ISignUpService {

	
	public static final Logger log1 = Logger.getLogger(ISignUpService.class.getName());


	public void addSignUp(SignUp signUp);

	
	public SignUp getSignUpByID(String signUpID);
	
	public ArrayList<SignUp> getSignUp();
	
	public SignUp updateSignUp(String signUpID, SignUp signUp);

	public void removeSignUp(String signUpID);

}
