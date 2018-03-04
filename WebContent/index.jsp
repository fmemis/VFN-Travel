	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!DOCTYPE html>
	<html lang="en">
	<head>
		<title>Site name</title>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link href='https://fonts.googleapis.com/css?family=Arizonia' rel='stylesheet' type='text/css'>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="css/datepicker.css">
		<link rel="stylesheet" href="css/index.css">
		<script>
		  $(function(){
			$('#datepicker').datepicker({
			  inline: true,
			  showOtherMonths: true,
			  dayNamesMin: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
			});
		  });
		</script>
		<script>
			$(function(){
				$('#datepicker2').datepicker({
				  inline: true,
				  showOtherMonths: true,
				  dayNamesMin: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
				});
			  });
		</script>

	</head>

	<body>

		<div class="jumbotron text-center" >
			<div class="row">
				<div class="col-md-offset-9">
					<div class="row-fluid">
						<%
							String username= (String) session.getAttribute("username");
							if (username == null) {
						%>
						<a id="trial" class="btn btn-lg commonbtn" data-toggle="modal" href="#login_overlay">Login</a>
						<div class="dropdown">
							<button class="btn dropdown-toggle btn-lg commonbtn" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style = "margin-left: 0px;">
								Register as
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="Registration">Traveler</a></li>
								<li><a href="PrRegistration">Owner</a></li>
							</ul>
						</div>
						<% } else {
						%>
						<a href="Logout" class="btn btn-lg commonbtn">Logout</a>
						 <a href="userprofile" class="btn btn-lg commonbtn">Profile</a>

						<% }%>
						<ul class="list-inline">
							<li><a href="#" style = "color: white;font-size: 150%;">About</a></li>
							<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#" style = "color: white; font-size: 150%;">
									Contact
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
								  <li><a href="#">Phone</a></li>
								  <li><a href="#">Email</a></li>
								  <li><a href="#">Schedule Appointment</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<h1 style = "font: 400 100px/1.3 , Helvetica, sans-serif; color: white;">VFN TRAVEL</h1>

			<div class="container">
				<div class="row">
						  <form class="form-inline" role="form" method="post" action="Search">
						  <div class="col-md-3 col-sm-12 col-xs-12">
							<div class="form-group has-feedback " style="margin-top:2em">
							  <span class="glyphicon glyphicon-home form-control-feedback"></span>
							  <input type="text" class="form-control" name="City" placeholder="Choose a city" style="box-sizing: content-box;">
							</div>
							</div>

							<div class="col-md-3 col-sm-12 col-xs-12">
							<div class="form-group has-feedback " style="margin-top:2em">
							  <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
							  <input type="text" id="datepicker" name="arrival" class="form-control" placeholder="Arrival date" style="box-sizing: content-box;">
							</div>
							</div>

							<div class="col-md-3 col-sm-12 col-xs-12">
							<div class="form-group has-feedback" style="margin-top:2em">
							  <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
							  <input type="text" id="datepicker2" name="departure" class="form-control" placeholder="Departure date" style="box-sizing: content-box;">
							</div>
							</div>

							<div class="col-md-3 col-sm-12 col-xs-12">
							<div class="form-group has-feedback" style="margin-top:2em; margin-bottom: 2em">
							  <span class="glyphicon glyphicon-user form-control-feedback"></span>
							  <input type="text" class="form-control" name="guests" placeholder="Number of guests" style="box-sizing: content-box;">
							</div>
							</div>

							<div style="padding-top:7em; margin-top:2em">
							<button type="submit" class="btn-lg submit_3">Search...</button>
							</div>
						  </form>

				</div>
			</div>
		</div>


		<br><br><br><br><br><br><br><br><br><br>

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