<%@page import="model.LocalRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.LocalRequestServiceImp" %>
<%@page import="service.ILocalRequestService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"   href="css/table.css">
<script type="text/javascript">
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
</script>
</head>
<body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Manage <b>Your Orders</b></h2>
					</div>
					<div class="col-sm-6">
					<form method="POST" action="LocalRequestForm.jsp">
						<button class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>New Request</span></button>
						</form>
								
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
                       <th>LocalRequest ID</th>
		                <th>Company Name</th>
		                <th>Company Address</th>
		                <th>Email</th>
		                <th>Fax</th>
		                <th>Mobile Number</th>
		                <th>Office Number 1</th>
		                <th>Office Number 2</th>
		                <th>Type of Tea</th>
		                <th>Quantity</th>
                        <th>Actions</th>
                    </tr>
                </thead>
    
           <tbody>
        
        	<%
        	ILocalRequestService iLocalRequestService = new LocalRequestServiceImp();
        	ArrayList<LocalRequest> arrayList = iLocalRequestService.getLocalRequests();
        	
        	for(LocalRequest localRequest : arrayList){
        	%>
           <tr>
           
           <td> <span class="custom-checkbox">
								<input type="checkbox" id="checkbox2" name="options[]" value="1">
								<label for="checkbox2"></label>
							</span></td>
							
				<td> <%=localRequest.getLocalRequestCompanyID() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyName() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyAddress() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyEmail() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyFax() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyMobile() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyOffice1() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyOffice2() %> </td>	
				<td> <%=localRequest.getLocalRequestCompanyTeaType() %> </td>
				<td> <%=localRequest.getLocalRequestCompanyQuntity() %> </td>
				<td>
				<form method="POST" action="GetLocalRequestServlet">
				<input type="hidden" name="localRequestID" value="<%=localRequest.getLocalRequestCompanyID()%>"/>
						 <button class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></button>
                            
				</form>
				</td>
			<%	
			   }
            %>     
          </tbody>
        </table>
    </div>
    </div>    
    
       
        
</body>
</html>