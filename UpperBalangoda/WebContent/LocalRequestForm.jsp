 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Uper Balangoda Tea Factory</title>
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
    
     <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/formLocal.css" rel="stylesheet" media="all">
  </head>
  <body>
   <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">Upper Balangoda Tea Factory</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        	<li class="nav-item"><a href="index.jsp" class="nav-link">Home</a></li>
	        	<li class="nav-item active"><a href="about.html" class="nav-link">About</a></li>
	        	<li class="nav-item"><a href="menu.html" class="nav-link">Menu</a></li>
	        	<li class="nav-item"><a href="blog.html" class="nav-link">Stories</a></li>
	          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
	          <li class="nav-item cta"><a href="reservation.html" class="nav-link">Book a table</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/formPhoto1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center mb-4">
            <h1 class="mb-2 bread">Request Order</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Request Order <i class="ion-ios-arrow-forward"></i></span></p>
          </div>
        </div>
      </div>
    </section>    

	
	<div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Request Your Order Here</h2>
                </div>
                <div class="card-body">
                    <form method="POST" action="AddLocalRequestServlet">
                    
                    <div class="form-row">
                            <div class="name">Company</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="LCompany">
                                </div>
                            </div>
                        </div>
                        
                         <div class="form-row">
                            <div class="name">Address</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="LAddress">
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Email</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="Lemail">
                                </div>
                            </div>
                       	</div>
                       	
                       	<div class="form-row">
                            <div class="name">Fax</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="Lfax">
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Mobile Number</div>
                            <div class="value">
                                <div class="input-group">
                                <input class="input--style-5" type="tel"  name="LMphone" >
                            </div>
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Office Number</div>
                            <div class="value">
                                <div class="input-group">
                                <input class="input--style-5" type="tel"  name="LO1phone" >
                            </div>
                            </div>
                        </div>
                        
                         <div class="form-row">
                            <div class="name">Office Number</div>
                            <div class="value">
                                <div class="input-group">
                                <input class="input--style-5" type="tel"  name="LO2phone" >
                            </div>
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Type of Tea</div>
                            <div class="value">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="LteaType">
                                            <option disabled="disabled" selected="selected">Choose Tea Type</option>
                                            <option>BOPF</option>
                                            <option>BOPA</option>
                                            <option>BOPSP</option>
                                            <option>BOPI</option>
                                            <option>FBOP</option>
                                            <option>FBOPF</option>
                                            <option>OP</option>
                                            <option>WHITE TEA</option>
                                            <option>GREEN TEA</option>
                                            <option>OOLANG TEA</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-row m-b-55">
                            <div class="name">Quantity(kg)</div>
                            <div class="value">
                                <div class="row row-refine">
                                    <div class="col-3">
                                        <div class="input-group-desc">
                                            <input class="input--style-5" type="number" name="LQuantity">
                                            </div>
                                            </div>
                                            </div>
                                            </div>
                                            </div>
                                            
           <button class="btn btn--radius-2 btn--red" type="submit">Order</button>
           <button class="btn btn--radius-2 btn--red" type="reset">Clear</button>
           
           
                         
            </form>
            
            <br>
            
            <form method="POST" action="ListLocalRequestServlet">
				<button class="btn btn--radius-2 btn--red" type="submit">List Of Requests</button>
			</form>
         </div>
       </div>
     </div>
   </div>             
           
	

		
    <footer class="ftco-footer ftco-bg-dark ftco-section">
       <div class="container">
        <div class="row mb-5">
          <div class="col-md-6 col-lg-3">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Upper Balangoda Tea Factory</h2>
              <p>Upper Balangoda is a pioneer in distributing wide range of tea in Sri Lanka and Internationally.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Open Hours</h2>
              <ul class="list-unstyled open-hours">
                <li class="d-flex"><span>Monday</span><span>7.30AM - 7:00AM</span></li>
                <li class="d-flex"><span>Tuesday</span><span>7.30AM - 7:00AM</span></li>
                <li class="d-flex"><span>Wednesday</span><span>7.30AM - 7:00AM</span></li>
                <li class="d-flex"><span>Thursday</span><span>7.30AM - 7:00AM</span></li>
                <li class="d-flex"><span>Friday</span><span>7.30AM - 7:00AM</span></li>
                <li class="d-flex"><span>Saturday</span><span>7.30AM - 7:00AM</span></li>
                <li class="d-flex"><span>Sunday</span><span> 7.30AM - 7:00AM</span></li>
              </ul>
            </div>
          </div>
          <div class="col-md-6 col-lg-3">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Instagram</h2>
              <div class="thumb d-sm-flex">
	            	<a href="#" class="thumb-menu img" style="background-image: url(images/footerImage1.jpg);">
	            	</a>
	            	<a href="#" class="thumb-menu img" style="background-image: url(images/footerImage2.jpg);">
	            	</a>
	            	<a href="#" class="thumb-menu img" style="background-image: url(images/footerImage3.jpg);">
	            	</a>
	            </div>
	            <div class="thumb d-flex">
	            	<a href="#" class="thumb-menu img" style="background-image: url(images/footerImage4.jpg);">
	            	</a>
	            	<a href="#" class="thumb-menu img" style="background-image: url(images/footerImage5.jpg);">
	            	</a>
	            	<a href="#" class="thumb-menu img" style="background-image: url(images/footerImage6.jpg);">
	            	</a>
	            </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Newsletter</h2>
            	<p>Send Your Feedback To Us.</p>
              <form action="#" class="subscribe-form">
                <div class="form-group">
                  <input type="text" class="form-control mb-2 text-center" placeholder="Enter email address">
                  <input type="submit" value="Subscribe" class="form-control submit px-3">
                </div>
              </form>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> Upper Balangoda Tea Company , All rights reserved </p>
          </div>
        </div>
      </div>
    </footer>
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body>
</html>