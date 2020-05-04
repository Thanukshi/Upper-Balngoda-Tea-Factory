package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SignUp;
import service.ISignUpService;
import service.SignUpServiceImp;

/**
 * Servlet implementation class AddSignUp
 */
@WebServlet("/AddSignUpServlet")
public class AddSignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSignUpServlet() {
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
		doGet(request, response);
		
		response.setContentType("text/html");

		SignUp signUp = new SignUp();
		
		signUp.setCompanyType(request.getParameter("signUpCompanyType"));
		signUp.setCompanyName(request.getParameter("SignUpCompanyName"));
		signUp.setUserName(request.getParameter("SignUpUserName"));
		signUp.setCompanyPassword(request.getParameter("SignUpPassword"));
		signUp.setCompanyRePassword(request.getParameter("SignUpConfirmPassword"));
		
		ISignUpService iSignUpService = new SignUpServiceImp();
		iSignUpService.addSignUp(signUp);

		
		

		request.setAttribute("signUp", signUp);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginConnect.jsp");
		dispatcher.forward(request, response);
	}

}
