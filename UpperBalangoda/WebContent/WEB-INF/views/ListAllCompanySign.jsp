<%@page import="model.SignUp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.SignUpServiceImp" %>
<%@page import="service.ISignUpService"%>
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
						<h2>Manage <b>All Companies</b></h2>
					</div>
					<div class="col-sm-6">
					
					<form method="POST" action="LoginConnect.jsp">
						<button class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Company</span></button>
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
                        <th>Company ID</th>
		            	<th>Type of Company</th>
		                <th>Company Name</th>
		                <th>User Name</th>
		                <th>Password</th>
                		<th>Confirm Password</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                        
                <tbody>
		                    <%
		        	ISignUpService iSignUpService = new SignUpServiceImp();
		        	ArrayList<SignUp> arrayList = iSignUpService.getSignUp();
		        	
		        	for(SignUp signUp : arrayList){
		        	%>
		           <tr>
		           		<td> <span class="custom-checkbox">
								<input type="checkbox" id="checkbox2" name="options[]" value="1">
								<label for="checkbox2"></label>
							</span></td>
						<td> <%=signUp.getCompanyID() %> </td>
						<td> <%=signUp.getCompanyType() %> </td>
						<td> <%=signUp.getCompanyName() %> </td>
						<td> <%=signUp.getUserName() %> </td>
						<td> <%=signUp.getCompanyPassword() %> </td>
						<td> <%=signUp.getCompanyRePassword() %> </td>
						<td>
				<form method="POST" action="GetSignUpServlet">
				<input type="hidden" name="signUpID" value="<%=signUp.getCompanyID()%>"/>
						 <button class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></button>
                            
				</form>
				</td>
					</tr>
					
					<%	
			   }
            %>   
					
					
         </tbody>
    </table>
</div>
</div>
</body>
</html>                                		                                 