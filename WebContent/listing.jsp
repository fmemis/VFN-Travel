	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>

		<meta charset="utf-8">
		<title>Listing</title>
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
		<link rel="stylesheet" href="css/listing.css">
		


		<script type="text/javascript" src=" https://maps.googleapis.com/maps/api/js?key=AIzaSyCveR_EPUDL3tOVde7lqtD0JpZpMQ4pEWQ&callback=initMap"></script>
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

		<script type="text/javascript">
			var map;

			function InitializeMap(){
				var x = parseFloat(${listing.getLatitude()});
				var y = parseFloat(${listing.getLatitude()});
				var latlng = new google.maps.LatLng(x,y);
				var myOptions ={
					zoom: 15,
					center: latlng,
					mapTypeId: google.maps.MapTypeId.ROADMAP,
					disableDefaultUI: true
				};
				map = new google.maps.Map(document.getElementById("map"), myOptions);
				var myLatLng = {lat: x, lng: y};
				var marker = new google.maps.Marker({
					position: myLatLng,
					map: map,
					title: '${listing.getName()}'
				});
			}

			window.onload = InitializeMap;

		</script>

		<script src="jquery.js"></script>
		<script>
		$(function(){
		  $("#NavBar").load("NavBar.jsp");
		});
		</script>

	</head>

	<style>

		body{
			padding-top: 40px;
		}

		.jumbotron{
			<c:choose>
		   <c:when  test="${count =='0'}" >
		        background-image: url('images/japan.jpg');
		    </c:when>    
		    <c:otherwise>
		        background-image: url('image/${listing.getImages().get(0).photo}');
		    </c:otherwise>
		</c:choose>;

			background-color: #33ccff;
			color: white;
			margin-bottom: 0;
			min-height: 50%;
			background-size: cover;
			background-position: 100% 50%;
			height: 50vh;
		}


		<% int count = (int) request.getAttribute("count");
				if (count != 0) {

		%>


		.slide1{
			background-image: url('image/${listing.getImages().get(0).photo}');
			height: 500px;
			background-repeat: no-repeat;
			background-position: center;
			background-size: cover;
		}

		<% } %>


		<%
				if (count > 1) {

		%>
		.slide2{
		  background-image: url('image/${listing.getImages().get(1).photo}');
		  height: 500px;
		  background-repeat: no-repeat;
		  background-position: center;
		  background-size: cover;
		}

		<% } %>

		<%
				if (count > 2) {

		%>
		.slide3{
		  background-image: url('image/${listing.getImages().get(2).photo}');
		  height: 500px;
		  background-repeat: no-repeat;
		  background-position: center;
		  background-size: cover;
		}
		<% } %>

		<%
				if (count > 3) {

		%>
		.slide4{
		  background-image: url('image/${listing.getImages().get(3).photo}');
		  height: 500px;
		  background-repeat: no-repeat;
		  background-position: center;
		  background-size: cover;
		}
		<% } %>

		<%
				if (count > 4) {

		%>
		.slide5{
		  background-image: url('image/${listing.getImages().get(4).photo}');
		  height: 500px;
		  background-repeat: no-repeat;
		  background-position: center;
		  background-size: cover;
		}
		<% } %>

		<%
				if (count > 5) {

		%>
		.slide6{
		  background-image: url('image/${listing.getImages().get(5).photo}');
		  height: 500px;
		  background-repeat: no-repeat;
		  background-position: center;
		  background-size: cover;
		}
		<% } %>

	</style>



	<body data-spy="scroll" data-target="#my-navbar">
		<div id = "NavBar" style = "margin-top:0px;"></div>


		<div class="jumbotron">
			<div class="container text-center">

			</div>
		</div>

		<hr>

	<div class="container" >
	<div class="well" style="border:solid; background:white; border-width: 1px;">
		<form method="get" action = "Reservation">
			<input type="hidden" name="listid" value="${param.listingid }" />
			<input type="hidden" name="listprov" value="${param.provname }" />
			<section>

			<div style="float:left;margin-right:2em;">
				<label for="datepicker" style="color:#006dcc">Arrival</label>
				<input type="text" value="${param.arrival }" id="datepicker" placeholder="arrival date" name="datepicker" style="border-radius: 5px">
			</div>

			<div style="float:left;margin-right:2em">
				<label for="datepicker2" style="color:#006dcc">Departure</label>
				<input type="text" value="${param.departure }" id="datepicker2" placeholder="departure date" name="datepicker2" style="border-radius: 5px">
			</div>

			<div style="float:left;margin-right:2em">
				<label for="guests" style="color:#006dcc">Guests</label>
				<select class="form-control" id="guests" name = "guests">
					<c:forEach begin = "1" end = "${listing.getMaxPeople()}" var="iterator">
					<option>${iterator}</option>
					</c:forEach>
				</select>
			</div>

			<%-- <input type = "hidden" name = "price" value = ${ daily_price}>
			<input type = "hidden" name = "idlisting" value = ${ listingid}>
			<input type = "hidden" name = "provname" value = ${ provname}> --%>

			<%
							String username= (String) session.getAttribute("username");
							if (username != null) {
			 %>

			<button type = "submit" class="btn btn-primary btn-lg" style="margin-top:0.5em"> Make a reservation </button>

			<% } else {
			 %>
					<a id="log1" class="btn btn-primary btn-lg" style="margin-top:0.5em" data-toggle="modal" href="#login_overlay2" type="hidden">Make a reservation</a>
			 <% }%>

			<br style="clear:both;" />

			</section>

		</form>
		</div>
	</div>



	<div class="row">
		<div class="container">
		<div class="page-header" id="description">
					<h1>Description</h1>
				</div>

		<textarea rows="4" cols="50" style="border:none">
		${listing.getDescription()}
		</textarea>
			<h3>Features</h3>
		  <table class="table">
			<tbody>
			  <tr>
				<td>Type: ${listing.getType()}</td>
				<td>Beds: ${listing.getBedsNumber()}</td>
				<td>bedrooms: ${listing.getRoomsNumber()}</td>
			  </tr>
			  <tr>
				<td>Bathrooms: ${listing.getBathsNumber() }</td>
				<td>Living room: yes</td>
				<td>Size: ${listing.getSize() }</td>
			  </tr>
			</tbody>
		  </table>

		</div>

	</div>

	<!-- Gallery -->
		<div class="container">
			<section>
				<div class="page-header" id="gallery">
					<h1>Gallery.</h1>
				</div>

				<div id="theCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#theCarousel" data-slide-to="0" class="active"> </li >
				<li data-target="#theCarousel" data-slide-to="1"> </li>
				<li data-target ="#theCarousel" data-slide-to="2"> </li>
				<li data-target ="#theCarousel" data-slide-to="3"> </li>
				<li data-target ="#theCarousel" data-slide-to="4"> </li>
				<li data-target ="#theCarousel" data-slide-to="5"> </li>
			</ol >

			<div class="carousel-inner">
			<%
				if (count > 0) {

			%>
				<div class="item active" >
					<div class ="slide1"></div>
				</div>
				<% } %>
			<%
				if (count > 1) {

			%>
				<div class="item">
					<div class="slide2"></div>
				</div>
				<% } %>
			<%
				if (count > 2) {

			%>
				<div class="item">
					<div class="slide3"></div>
				</div>
				<% } %>
				<%
				if (count > 3) {

				%>
				 <div class="item">
					<div class="slide4"></div>
				</div>
				<% } %>
				<%
				if (count > 4) {

				%>
				<div class="item">
					<div class="slide5"></div>
				</div>
				<% } %>
				<%
				if (count > 5) {

				%>
				<div class="item">
					<div class="slide6"></div>
				</div>
				<% } %>
			</div>

			<a class="left carousel-control" href="#theCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
			<a class="right carousel-control" href="#theCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
		</div>

			</section>
		</div>


	<div class="container">

	 <div class="row">
	  <div class="col-md-8" >
		<h2 class="page-header" id = "reviews">Reviews</h2>
		<c:forEach items="${searchResults}" var="review" varStatus="count">
		<section class="comment-list">
		  <div class="row">
			<div class="col-md-2 col-sm-2 hidden-xs">
			  <figure class="thumbnail">
				<img class="img-responsive" src="image/${review.user.photo }" />
				<figcaption class="text-center">${review.user.username}</figcaption>
			  </figure>
			</div>
			<div class="col-md-10 col-sm-10">
			  <div class="panel panel-default arrow left">
				<div class="panel-body">
				  <div class="comment-post">
					<p>
					  ${review.text }
					</p>
				  </div>
				  <c:forEach begin = "1" end = "${review.score}" var="iterator">
					<span class="glyphicon glyphicon-star"></span>
				   </c:forEach>
				</div>
			  </div>
			</div>
		  </div>
	   </section>
	   </c:forEach>
	</div>
	</div>

	<%
		  String visited= (String) request.getAttribute("visit");
		  if (visited != null) {
	%>

	<h3>Rate your experience!</h3>
	<hr>
	<form method = "get" action = "Review">
		<input type="hidden" name="listid" value="${param.listingid }" />
		<input type="hidden" name="listprov" value="${param.provname }" />
	<div class="container">
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
	<div class="radio">
		  <label><input type="radio" name="optradio" value = "perfect">Perfect</label>
		</div>
		<div class="radio">
		  <label><input type="radio" name="optradio" value = "pretty good">Pretty good</label>
		</div>
		<div class="radio">
		  <label><input type="radio" name="optradio" value = "good">Good</label>
		</div>
		<div class="radio">
		  <label><input type="radio" name="optradio" value = "mediocre">Mediocre</label>
		</div>
		<div class="radio">
		  <label><input type="radio" name="optradio" value = "bad">Bad</label>
		</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" >
				Write a review:<br>
			<textarea id="myTextarea" name = "review"></textarea>
		</div>

		</div>
		<div class="col-lg-offset-4 col-md-offset-4" >
		<button type = "submit" class="btn btn-primary btn-md" style="margin-top:0.5em"> Submit! </button>
		</div>
	</form>
	</div>
	<% } %>
		<div class="container">
			<h1>Location</h1>
			<div id ="map" style="height: 500px; width: 1000px" ></div>
		</div>

	  <div class="container">
		<section>
		  <div class="page-header" id="Host">
			  <h1>Contact Owner</h1>
			</div>

			<div class="row">
			  <div class="col-lg-4">
			  <img class="img-responsive" src="image/${provider.photo }" />
			  <br>
			  <h3>${provider.name} ${provider.surname}</h3>
			  <br>
			  Tel: ${provider.telephone}
			  <br>
			  mobile: ${provider.cell}
			  <br>
			  Email: ${provider.email}
			  </div>


			  <div class="col-lg-8 col-lg-offset-4">
				<input type="hidden" name="listprov" value="${provider.name }" />
				 <a class="btn btn-large btn-info" href= "MessageServlet?param1=${param.provname}">Send a message to ${param.provname} </a>


			  </div>
			</div>

		</section>
	  </div>

	<!-- Footer -->

		<footer>
		  <hr>
			<div class="container text-center">

			<p>&copy; Copyright @ 2017</p>

		  </div>


		</footer>
		<!-- <a id="log" class="btn btn-lg commonbtn" data-toggle="modal" href="#login_overlay" type="hidden">Login</a> -->
		<div class="modal fade" id="login_overlay2">
			<div  class="modal-dialog">
				  <div class="modal-content">

					  <div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
						  <h4 class="modal-title" id="myModalLabel">Login</h4>

					  </div>
					  <div class="modal-body">
						   <div><%-- <c:if test="${not empty login}"> --%>
							   <div class="alert alert-danger" style="text-align: center;"> You must login first.</div>
							 <!--  <script> -->
								 <%--  //        document.getElementById('trial').click();
								  window.onload = function () {
									  document.getElementById("log").click();
								  }
							  </script>
							</c:if> --%>
							</div>
						  <div class="row">

							  <div class="logindiv" style="margin:0 auto;">
								  <div class="well" style="margin-left: 8px; margin-right: 8px">
									  <form class="group" id="loginForm" method="post" action="Login" novalidate="novalidate">
										<input type="hidden" name="listid" value="${param.listingid }" />
										<input type="hidden" name="listprov" value="${param.provname }" />
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