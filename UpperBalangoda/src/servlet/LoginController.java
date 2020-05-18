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
	SignUp su = new SignUp();
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
					Class.forName("org.mariadb.jdbc.Driver");
			 // loads driver
			Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/upperbalangoda", "root", "root"); // gets a new connection
		//	PreparedStatement ps = c.prepareStatement("select signUpUserName,signUpPassword from signUp where signUpUserName=? and signUpPassword=?");
			PreparedStatement ps = c.prepareStatement("select * from signUp where signUpUserName=? and signUpPassword=?");
			PreparedStatement ps1 = c.prepareStatement("select * from signUp where signUpUserName=? and signUpPassword=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ps1.setString(1, un);
			ps1.setString(2, pw);
			ResultSet rs = ps.executeQuery();
		/*	ResultSet rs1 = ps1.executeQuery();
			
			while (rs1.next()) {
				System.out.println(rs1.getString(1));
				su.setCompanyID(rs1.getString(1));
				su.setCompanyName(rs1.getString(3));
				su.setCompanyPassword(rs1.getString(5));
				su.setCompanyRePassword(rs1.getString(6));
				su.setCompanyType(rs1.getString(2));
				su.setUserName(rs1.getString(4));
				System.out.println(su.toString());
				
				s1 = rs1.getString(1);
				
			}*/
		while (rs.next()) {
			System.out.println(rs.getString(1));
			su.setCompanyID(rs.getString(1));
			su.setCompanyName(rs.getString(3));
			su.setCompanyPassword(rs.getString(5));
			su.setCompanyRePassword(rs.getString(6));
			su.setCompanyType(rs.getString(2));
			su.setUserName(rs.getString(4));
			System.out.println(su.toString());
			String s = su.getCompanyID()
;	
			request.setAttribute("s", s);
			request.setAttribute("su", su);
			
			if(un.equalsIgnoreCase("admin")) {
				request.getRequestDispatcher("bidMenu.jsp").forward(request, response);
				}
				else
				request.getRequestDispatcher("admin.jsp").forward(request, response);	
			return;
		}
		response.sendRedirect("error.jsp");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	}


