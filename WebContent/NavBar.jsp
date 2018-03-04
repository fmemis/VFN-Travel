	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://bootswatch.com/cosmo/bootstrap.min.css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/AirBnb2/css/navbar.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

	<script>
	$(document).ready(function(e) {
	$(window).scroll(function(){
		if ($(window).scrollTop() >= 500) {
		   $('nav').addClass('stick');
		}
		else {
		   $('nav').removeClass('stick');
		}
	});
	});
	</script>

	</head>
	<body>
	<%
							String username= (String) session.getAttribute("username");
							if (username == null) {
						%>
						<nav id="sticker" class="navbar">
						  <div class="container">
							<div class="navbar-header">
							 <a class="menu"><i class="fa fa-bars" id="menu_icon"></i></a>
							  <a class="navbar-brand" href="#">
								VFN Travel
							  </a>
							</div><!--navbar-header close-->
							<div class="collapse navbar-collapse drop_menu" id="content_details">
							  <ul class="nav navbar-nav navbar-right">

						<li><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
						<li><a href="#login_overlay" data-toggle="modal"><span class="glyphicon glyphicon-log-in" ></span>LogIn</a></li>



		   <li><a href="about.jsp"><span class="glyphicon glyphicon-heart-empty"></span> About Us</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> Contact Us</a></li>

			<li class="dropdown">
							<button class="btn btn-info btn-lg" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style = "margin-left: 0px;">
								Register as
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="Registration">Traveler</a></li>
								<li><a href="PrRegistration">Owner</a></li>
							</ul>
						</li>


		  </ul><!--navbar-right close-->
		</div><!--collapse navbar-collapse drop_menu close-->
	  </div><!--container-fluid close-->
	</nav><!--navbar navbar-inverse close-->
						<% } else {
						%>
						<nav id="sticker" class="navbar">
						  <div class="container">
							<div class="navbar-header">
							 <a class="menu"><i class="fa fa-bars" id="menu_icon"></i></a>
							  <a class="navbar-brand" href="#">
								VFN Travel
							  </a>
							</div>
							<div class="collapse navbar-collapse drop_menu" id="content_details">
							  <ul class="nav navbar-nav navbar-right">

						<li><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
						<li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
						<li><a href="userprofile"><span class="glyphicon glyphicon-font"></span> Profile</a></li>

			<li><a href="about.jsp"><span class="glyphicon glyphicon-heart-empty"></span> About Us</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> Contact Us</a></li>


		  </ul>
		</div>
	  </div>
	</nav>


						<% }%>

						<div class="modal fade" id="login_overlay">
			<div  class="modal-dialog">
				  <div class="modal-content">

					  <div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
						  <h4 class="modal-title" id="myModalLabel">Login</h4>

					  </div>
					  <div class="modal-body">
						   <div><c:if test="${not empty msg}">
							  <div class="alert alert-danger" style="text-align: center;"> Wrong username or password.</div>
							  <script>
								  //        document.getElementById('trial').click();
								  window.onload = function () {
									  document.getElementById("trial").click();
								  }
							  </script>
							</c:if>
							</div>
						  <div class="row">

							  <div class="logindiv" style="margin:0 auto;">
								  <div class="well" style="margin-left: 8px; margin-right: 8px">
									  <form class="group" id="loginForm" method="post" action="Login?listid" novalidate="novalidate">

										  <div class="form-group">
											  <label for="Username" class="control-label">Username</label>
											  <input  class="form-control"  name="username" value="" required="required"  placeholder="Username">
											  <span class="help-block"></span>
										  </div>
										  <div class="form-group">
											  <label for="password" class="control-label">Password</label>
											  <input type="password" class="form-control"  name="password" value="" required="required"  placeholder="Password">
											  <span class="help-block"></span>
										  </div>


										  <div  class="form-group" style="display:inline-block">

										 </div>
										  <button type="submit" class="btn btn-success btn-block">Login</button>

									  </form>
								</div>
							  </div>
						</div>
					</div>
				</div>
			  </div>
		</div>

	</body>
	</html>