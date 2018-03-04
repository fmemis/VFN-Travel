	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!DOCTYPE html>

	<html>
	<head>
	<title>Your registration needs approvement</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/AirBnb2/css/providerappr.css" type="text/css">
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
		  <div class = "one">
			<div class = "jumbotron">
				<div class = "container">
				</div>
			</div>
		  </div>
		  <div class = "two">
			<div class = "jumbotron">
				<div class = "container">
					<p>Thank you for your registration.Your application needs to be reviewed
						and approved by our administrators.Until then you can log in as a simple user.
						Sorry for the inconvenience.
				</div>
			</div>
		  </div>
	</body>
	</html>



