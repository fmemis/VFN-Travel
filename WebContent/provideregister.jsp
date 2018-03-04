	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!DOCTYPE html>

	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/AirBnb2/signu.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


	<script src="jquery.js"></script>
		<script>
		$(function(){
		  $("#NavBar").load("NavBar.jsp");
		});
		</script>

	</head>
		<body>
			<div id = "NavBar"></div>
			<div class="container">
				<div class="row centered-form">
				<div class="col-l-12 col-md-6 col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="col-l-12">
						<div class="wrap">
							<p class="form-title">
								Sign Up for our site</p>
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									 <p>Already have an account?</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									 <a href="login.jsp" style="color:rgb(0, 0, 255)">Log in</a>
								</div>
							</div>
							 <c:if test="${not empty msg}">
								${msg}
							</c:if>
							<div class="well">
								<form role="form" action="PrRegistration" method="post" enctype="multipart/form-data">
									<div class="row">
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
											<label for="Username" class="control-label">First Name</label>
												 <input type="text" name="name" id="name" class="form-control input-sm" placeholder="First Name" required="required" value="${name}">
											</div>
										</div>
										<div class="col-xs-6 col-sm-6 col-md-6">
											<div class="form-group">
												<label for="Username" class="control-label">Last Name</label>
												<input type="text" name="surname" id="surname" class="form-control input-sm" placeholder="Last Name" required="required" value="${surname}">
											</div>
										</div>
									</div>

									 <div class="form-group">
										<label for="Username" class="control-label">Email Address</label>
										<input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address" required="required" value="${email}">
									</div>

									<div class="form-group" >
										<label for="Username" class="control-label">Username</label>
										<input type="text" name="username" class="form-control input-sm" placeholder="Username" required="required" value="${username}">
									</div>

								<div class="form-group" >
										<label for="Username" class="control-label">Trn</label>
										<input type="text" name="Trn" class="form-control input-sm" placeholder="Trn" required="required" value="${trn}">
									</div>

								<div class="row">
									<div class="col-xs-6 col-sm-6 col-md-6">
										<div class="form-group">
											<label for="Username" class="control-label">Password</label>
											<input type="password" name="pass" id="pass" class="form-control input-sm" placeholder="Password" required="required" value="${password}">
										</div>
									</div>
									<div class="col-xs-6 col-sm-6 col-md-6">
										<div class="form-group">
											<label for="Username" class="control-label">Confirm Password</label>
											<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-sm" placeholder="Confirm Password" required="required" value="${passc}">
										</div>
									</div>
								</div>
								<div class="form-group">
										<label for="Username" class="control-label">Cellphone Number</label>
										<input type="text" name="cell" id="cell" class="form-control input-sm" placeholder="Cellphone number" required="required" value="${cell}">
								</div>
								<div class="form-group">
										<label for="Username" class="control-label">Telephone</label>
										<input type="text" name="telephone" id="telephone" class="form-control input-sm" placeholder="Telephone number" required="required" value="${telephone}">
								</div>
								<div class="form-group">
										<label for="Username" class="control-label">Country</label>
										<input type="text" name="country" id="country" class="form-control input-sm" placeholder="Country" value="${country}">
								</div>
								<div class="form-group">
										<label for="Username" class="control-label">City</label>
										<input type="text" name="city" id="city" class="form-control input-sm" placeholder="City" value="${city}">
								</div>
								<div class="form-group" align="center" style = "margin-bottom:15px;">

											<div class="box">
												<input type="file" name="uploadingFile" id="file-1" class="inputfile inputfile-1" data-multiple-caption="{count} files selected"  style="display: none;" />
												<label for="file-1"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Upload A Photo&hellip;</span></label>
											</div>
								 </div>
								 <input type="submit" value="Register" class="btn btn-info btn-block">
								<!-- <button type="submit" class="btn btn-default">Submit</button> -->
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