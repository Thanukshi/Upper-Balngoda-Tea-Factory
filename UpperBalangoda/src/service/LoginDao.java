package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import model.SignUp;
import util.DBConnectionUtil;

;
 
public class LoginDao {
 
public String authenticateUser(SignUp signUp)
{
    String userName = signUp.getUserName();
    String password = signUp.getCompanyPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String roleDB = "";
 
    try
    {
        try {
			con = DBConnectionUtil.getDBConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        statement = con.createStatement();
        resultSet = statement.executeQuery("select signUpName,signUpPassword from signUp");
 
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            
 
            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
            return "Admin_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
            return "Editor_Role";
            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
            return "User_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}
}