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
public class AddLocalRequestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLocalRequestServlet() {
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

		LocalRequest LocalRequest = new LocalRequest();
		
		LocalRequest.setLocalRequestCompanyName(request.getParameter("LCompany"));
		LocalRequest.setLocalRequestCompanyAddress(request.getParameter("LAddress"));
		LocalRequest.setLocalRequestCompanyEmail(request.getParameter("Lemail"));
		LocalRequest.setLocalRequestCompanyFax(request.getParameter("Lfax"));
		LocalRequest.setLocalRequestCompanyMobile(request.getParameter("LMphone"));
		LocalRequest.setLocalRequestCompanyOffice1(request.getParameter("LO1phone"));
		LocalRequest.setLocalRequestCompanyOffice2(request.getParameter("LO2phone"));
		LocalRequest.setLocalRequestCompanyTeaType(request.getParameter("LteaType"));
		LocalRequest.setLocalRequestCompanyQuntity(request.getParameter("LQuantity"));

		ILocalRequestService iLocalRequestService = new LocalRequestServiceImp();
		iLocalRequestService.addLocalRequest(LocalRequest);

		request.setAttribute("LocalRequest", LocalRequest);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListLocalRequests.jsp");
		dispatcher.forward(request, response);
	}

}


