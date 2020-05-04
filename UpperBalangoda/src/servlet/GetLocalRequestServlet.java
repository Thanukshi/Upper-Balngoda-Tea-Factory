package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LocalRequest;
import service.LocalRequestServiceImp;
import service.ILocalRequestService;

/**
 * Servlet implementation class LoginServlet
 */
public class GetLocalRequestServlet extends HttpServlet {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetLocalRequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

 		String localRequestID = request.getParameter("localRequestID");	
 		System.out.println(localRequestID);
		ILocalRequestService iLocalRequestService = new LocalRequestServiceImp();
		LocalRequest localRequest = iLocalRequestService.getLocalRequestByID(localRequestID);

		request.setAttribute("localRequest", localRequest);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetLocalRequest.jsp");
		dispatcher.forward(request, response);
	}

}
