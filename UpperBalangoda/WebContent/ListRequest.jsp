<%@page import="java.io.OutputStream"%>
<%@ page contentType="application/pdf" %>   
<%@ page trimDirectiveWhitespaces="true"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.design.JRDesignQuery"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<head>

<title>Gallery Report</title>
</head>
<body>
<%
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/upperbalangoda", "root", "root");
			
			String report = "C:/Users/thanu/JaspersoftWorkspace/MyReports/request_list.jrxml";
			
			JasperReport jasperreport = JasperCompileManager
					.compileReport(report);
			
			JasperPrint jp = JasperFillManager.fillReport(jasperreport,
					null, conn);
			
			JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (Exception e) {
			out.println(e);
		}
	%>
</body>
</html>