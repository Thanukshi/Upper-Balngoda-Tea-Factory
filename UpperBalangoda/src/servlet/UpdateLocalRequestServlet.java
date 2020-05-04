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
 * Update localRequests servlet
 */
public class UpdateLocalRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateLocalRequestServlet() {
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

		LocalRequest localRequest = new LocalRequest();
		String localRequestID = request.getParameter("localRequestID");	
		localRequest.setLocalRequestCompanyID(localRequestID);
		localRequest.setLocalRequestCompanyName(request.getParameter("LCompany"));
		localRequest.setLocalRequestCompanyAddress(request.getParameter("LAddres"));
		localRequest.setLocalRequestCompanyEmail(request.getParameter("Lemail"));
		localRequest.setLocalRequestCompanyFax(request.getParameter("Lfax"));
		localRequest.setLocalRequestCompanyMobile(request.getParameter("LMphone"));
		localRequest.setLocalRequestCompanyOffice1(request.getParameter("LO1phone"));
		localRequest.setLocalRequestCompanyOffice2(request.getParameter("LO2phone"));
		localRequest.setLocalRequestCompanyTeaType(request.getParameter("LteaTypey"));
		localRequest.setLocalRequestCompanyQuntity(request.getParameter("LQuantity"));
		
		System.out.println(request.getParameter("LAddres"));
		ILocalRequestService iLocalRequestService = new LocalRequestServiceImp();
		iLocalRequestService.updateLocalRequest(localRequestID, localRequest);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListLocalRequests.jsp");
		dispatcher.forward(request, response);
	}

}
