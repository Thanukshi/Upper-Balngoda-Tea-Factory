<%@page import="model.SignUp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
 <title>About - Upper Balangoda Tea Factory</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  <link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Arimo' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Hind:300' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
  
  
      <link rel="stylesheet" href="css/styleProf.css">

  
</head>

<body>


 <%
		SignUp signUp = (SignUp) request.getAttribute("signUp");
	%>
  <div id="login-button">
  <img src="http://dqcgrsy5v35b9.cloudfront.net/cruiseplanner/assets/img/icons/login-w-icon.png">
  </img>
</div>
<div id="container">
  <h1>My Account</h1>
  <span class="close-btn">
    <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
  </span>

  <form >
    <input type="text" name = "signUpID" value="<%=signUp.getCompanyID()%>" readonly="readonly">
    <input type="text" name = "typeOfCompany" value="<%=signUp.getCompanyName()%>" readonly="readonly">
    <input type="text" name = "SignUpUserName" placeholder="User Name " value="<%=signUp.getUserName()%>" readonly="readonly" />
    <input type="text" name = "SignUpPassword"  placeholder="Password "  value="<%=signUp.getCompanyPassword()%>" readonly="readonly" />
      
</form>
	<form method="POST" action="EditCompanyGetSignUpServlet">
		<input type="hidden" name="signUpID" value="<%=signUp.getCompanyID()%>"/>
		<button >Edit Account</button>
	</form>
	
	<form method="POST" action="CompanyDeleteSignUpServlet">
		<input type="hidden" name="signUpID" value="<%=signUp.getCompanyID()%>"/>
		<button >Delete Account</button>
	</form>
	
	<form method="POST" action="index.jsp">
		<button >Go Back</button>
	</form>
</div>


  <script src='http://cdnjs.cloudflare.com/ajax/libs/gsap/1.16.1/TweenMax.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>

</body>
</html>
