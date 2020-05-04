package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.SignUp;
import util.CommonConstants;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	String s1;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		System.out.println(un);
		System.out.println(pw);
		// Connect to mysql and verify username password
		
		try {
	/*		Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
			//Connection l = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upperbalangoda", "root", "root" );
			Connection s = DriverManager.getConnection("jdbc:mysql://localhost:3306/upperbalangoda", "root", "root");
	//	Connection s = DriverManager.getConnection("jdbc:mariadb://localhost:3306/itp", "root", ""); // gets a new connection
		
		PreparedStatement ps = s.prepareStatement("select signUpUserName,signUpPassword from signUp where signUpUserName=? and signUpPassword=? ");
		
		//PreparedStatement ps1 = s.prepareStatement("select customerid from signUp where email=? and password=?");
		
		ps.setString(1, un);
		ps.setString(2, pw);
		//ps1.setString(1, un);
		//ps1.setString(2, pw);
		//SignUp signUp = new SignUp();
		ResultSet rs = ps.executeQuery();
		//ResultSet rs1 = ps1.executeQuery();
	
		
		/*
		while (rs1.next()) {
			System.out.println(rs1.getString(1));
			signUp.setCompanyID(rs1.getString(1));
			s1 = rs1.getString(1);
			continue;
		}


			
			PreparedStatement ps1 = c.prepareStatement("DROP TABLE IF EXISTS login");
			PreparedStatement ps2 = c.prepareStatement("create table login( userName varchar(20), pass varchar(20), primary key (userName))");
			PreparedStatement ps3 = c.prepareStatement("INSERT INTO login (userName, pass) VALUES ('admin', 'admin')");
			PreparedStatement ps4 = c.prepareStatement("INSERT INTO login (userName, pass) VALUES ('dmkk', 'dmkk')");
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			ResultSet rs4 = ps4.executeQuery();
	 */					Class.forName("org.mariadb.jdbc.Driver");
			 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/upperbalangoda", "root", "root"); // gets a new connection
			PreparedStatement ps = c.prepareStatement("select signUpUserName,signUpPassword from signUp where signUpUserName=? and signUpPassword=?");
			ps.setString(1, un);
			ps.setString(2, pw);
	 
			ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			response.sendRedirect("admin.jsp");
			return;
		}
		response.sendRedirect("error.html");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	}


