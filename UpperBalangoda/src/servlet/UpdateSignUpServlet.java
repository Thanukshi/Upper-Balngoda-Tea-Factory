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
 * Servlet implementation class UpdateSignUpServlet
 */
@WebServlet("/UpdateSignUpServlet")
public class UpdateSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSignUpServlet() {
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
		String signUpID =request.getParameter("signUpID");
		signUp.setCompanyID(signUpID);
		signUp.setCompanyType(request.getParameter("typeOfCompany"));
		signUp.setCompanyName(request.getParameter("singCompanyName"));
		signUp.setUserName(request.getParameter("SignUpUserName"));
		signUp.setCompanyPassword(request.getParameter("SignUpPassword"));
		signUp.setCompanyRePassword(request.getParameter("SignUpConfirmPassword"));
		
		
		ISignUpService iSignUpService = new SignUpServiceImp();
		iSignUpService.updateSignUp(signUpID, signUp);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListAllCompanySign.jsp");
		dispatcher.forward(request, response);
	}



}
