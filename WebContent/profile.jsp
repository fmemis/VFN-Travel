	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://bootswatch.com/cosmo/bootstrap.min.css">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="/AirBnb2/css/profile.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery.min.js"></script>
	<script src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	<script src="javascript/profile.js"></script>

	<title>Insert title here</title>
	<script>
	//tab js//
	
	</script>

	<script src="jquery.js"></script>
		<script>
		$(function(){
		  $("#NavBar").load("NavBar.jsp");
		});
		</script>

	</head>
	<body>
	<div id = "NavBar"></div>
	<!--search box-->
	<div class="container">
	  <!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

		  <!-- Modal content-->
		  <div class="modal-content">
			<div class="modal-header">
			  <button type="button" class="close" data-dismiss="modal">�</button>
			  <h4 class="modal-title">Search Section</h4>
			</div>
			<div class="modal-body">





			 <section class="search-box1" id="panel">
	  <div class="container">
		<form class="form-inline" role="form">
		  <div class="col-sm-8 col-xs-8 form-group top_search" style="padding-right:0px;">
			<div class="row">
			  <label class="sr-only" for="search">Search here...</label>
			  <span class="serach-footer"><img src="images/srch.png" /></span>
			  <input type="text" class="form-control search-wrap" id="search" placeholder="Search here...">
			</div>
		  </div>
		  <div class="row">
			<div class="col-sm-4 col-xs-4 form-group top_search" style="padding-left:0px;">
			  <button type="submit" class="btn btn-default search-btn">SEARCH</button>
			</div>
		  </div>
		</form>
	  </div>
	</section>



			</div>

			</div>
		  </div>

		</div>
	  </div>
	<br>
	<br>
	<br>












	<section>

	<div class="container" style="margin-top: 30px;">
	<div class="profile-head">
	<div class="col-md- col-sm-4 col-xs-12">
	<img src="image/${user.photo}" class="img-responsive" />
	 <h6><c:out value="${user.username}"/></h6>
	</div><!--col-md-4 col-sm-4 col-xs-12 close-->


	<div class="col-md-5 col-sm-5 col-xs-12">
	<h5><c:out value="${user.name}"/> <c:out value="${user.surname}"/></h5>

	<ul>
    <li><span class="glyphicon glyphicon-map-marker"></span> <c:out value="${user.country}"/></li>
    <li><span class="glyphicon glyphicon-home"></span> <c:out value="${user.city}"/></li>
    <li><span class="glyphicon glyphicon-phone"></span> <a href="#" title="call"><c:out value="${user.cell}"/></a></li>
    <li><span class="glyphicon glyphicon-envelope"></span><a href="#" title="email"><c:out value="${user.email}"/></a></li>

    </ul>


	</div><!--col-md-8 col-sm-8 col-xs-12 close-->




	</div><!--profile-head close-->
	</div><!--container close-->


	<div id="sticky" class="container">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs nav-menu" role="tablist">
		  <li class="active">
			  <a href="#table" role="tab" data-toggle="tab">
				  <i class="fa fa-male"></i> Profile
			  </a>
		  </li>
		  <li class="active">
			  <a href="#profile" role="tab" data-toggle="tab">
				  <i class="fa fa-male"></i> History
			  </a>
		  </li>
		  <li><a href="#change" role="tab" data-toggle="tab">
			  <i class="fa fa-key"></i> Edit Profile
			  </a>
		  </li>
		  <li><a href="UsersMessageServlet" >
			  <i class="fa fa-envelope"></i> My Messages
			  </a>
		  </li>

		</ul><!--nav-tabs close-->

	</div><!--col-md-12 close-->

	 <div class="tab-content">
			<div class="tab-pane fade in active" id="table">
			<h4 class="pro-title">Bio Graph</h4>
				<div class="container fom-main">
				<div class="col-md-6">

				<div class="table-responsive responsiv-table">
				  <table class="table bio-table">
					 <tbody>
				         <tr>
				            <td>Firstname</td>
				            <td><c:out value="${user.name}"/></td>
				         </tr>
				         <tr>
				            <td>Lastname</td>
				             <td><c:out value="${user.surname}"/></td>
				         </tr>
				        <tr>
				            <td>Username</td>
				            <td><c:out value="${user.username}"/></td>
				         </tr>
				        <tr>
				            <td>Country</td>
				            <td><c:out value="${user.country}"/></td>
				        </tr>
				         <tr>
				            <td>City</td>
				             <td><c:out value="${user.city}"/></td>
				         </tr>
				
				    </tbody>
				  </table>
				  </div><!--table-responsive close-->
				</div><!--col-md-6 close-->

				<div class="col-md-6">

				<div class="table-responsive responsiv-table">
				  <table class="table bio-table">
					  <tbody>
						<tr>
			            	<td>Email Id</td>
			             	<td><c:out value="${user.email}"/></td>
			        	</tr>
			         	<tr>
				            <td>Mobile</td>
				            <td><c:out value="${user.cell}"/></td>
			         	</tr>
			         	<tr>
				            <td>Phone</td>
				            <td><c:out value="${user.telephone}"/></td>
			        	</tr>

					</tbody>
				  </table>
				  </div><!--table-responsive close-->
				</div><!--col-md-6 close-->
		</div>
		</div>



		<div class="tab-pane fade" id="change">
		<div class="container fom-main">
		<div class="row">
		<div class="col-sm-12">
		<h2 class="register">Edit Your Profile</h2>
		</div><!--col-sm-12 close-->

		</div><!--row close-->
		<br />
		<div class="row">

		<form class="form-horizontal main_form text-left" action="userprofile" enctype="multipart/form-data" method="post"  id="contact_form">
		<fieldset>


		<div class="form-group col-md-12">
	      <label class="col-md-10 control-label">First Name</label>
	      <div class="col-md-12 inputGroupContainer">
	      <div class="input-group">
	      <input  name="first_name" placeholder=<c:out value="${user.name}"/> class="form-control"  type="text">
	        </div>
	      </div>
	    </div>
	
	    <!-- Text input-->
	
	    <div class="form-group col-md-12">
	      <label class="col-md-10 control-label" >Last Name</label>
	        <div class="col-md-12 inputGroupContainer">
	        <div class="input-group">
	      <input name="last_name" placeholder=<c:out value="${user.surname}"/> class="form-control"  type="text">
	        </div>
	      </div>
	    </div>
	
	    <!-- Text input-->
	           <div class="form-group col-md-12">
	      <label class="col-md-10 control-label">E-Mail</label>
	        <div class="col-md-12 inputGroupContainer">
	        <div class="input-group">
	      <input name="email" placeholder=<c:out value="${user.email}"/> class="form-control"  type="text">
	        </div>
	      </div>
	    </div>
	
	
	    <!-- Text input-->
	
	    <div class="form-group col-md-12">
	      <label class="col-md-10 control-label">Phone </label>
	        <div class="col-md-12 inputGroupContainer">
	        <div class="input-group">
	      <input name="phone" placeholder=<c:out value="${user.telephone}"/> class="form-control" type="text">
	        </div>
	      </div>
	    </div>
	
	    <!-- Text input-->
	
	     <div class="form-group col-md-12">
	      <label class="col-md-10 control-label">Country</label>
	        <div class="col-md-12 inputGroupContainer">
	        <div class="input-group">
	      <input name="country" placeholder=<c:out value="${user.country}"/> class="form-control" type="text">
	        </div>
	      </div>
	    </div>
	
	    <div class="form-group col-md-12">
	      <label class="col-md-10 control-label">City</label>
	        <div class="col-md-12 inputGroupContainer">
	        <div class="input-group">
	      <input name="city" placeholder=<c:out value="${user.city}"/> class="form-control" type="text">
	        </div>
	      </div>
	    </div>
	
	
	
	    <div class="form-group col-md-12">
	      <label class="col-md-10 control-label">Cell</label>
	        <div class="col-md-12 inputGroupContainer">
	        <div class="input-group">
	      <input name="cell" placeholder=<c:out value="${user.cell}"/> class="form-control" type="text">
	        </div>
	      </div>
	    </div>

		<!-- Select Basic -->


		<div class="form-group col-md-12">
		  <label class="col-md-10 control-label">Choose Password</label>
		  <div class="col-md-12 inputGroupContainer">
		  <div class="input-group">
		  <input  name="first_name" placeholder="Choose Password" class="form-control"  type="password">
			</div>
		  </div>
		</div>



		<div class="form-group col-md-12">
		  <label class="col-md-10 control-label">Confirm Password</label>
		  <div class="col-md-12 inputGroupContainer">
		  <div class="input-group">
		  <input  name="first_name" placeholder="Confirm Password" class="form-control"  type="password">
			</div>
		  </div>
		</div>



		<!-- upload profile picture -->
		<div class="col-md-12 text-left">
		<div class="uplod-picture">
		<span class="btn btn-default uplod-file">
			Upload Photo <input name="uploadingFile" type="file" />
		</span>
		
		</div><!--uplod-picture close-->
		</div><!--col-md-12 close-->
		<!-- Button -->
		<div class="form-group col-md-10">
		  <div class="col-md-6">
			<button type="submit" class="btn btn-info submit-button" >Save</button>
			<button type="submit" class="btn btn-info submit-button" >Cancel</button>

		  </div>
		</div>
		</fieldset>
		</form>
		</div><!--row close-->
		</div><!--container close -->
		</div><!--tab-pane close-->

	</div>

	</section><!--section close-->



	</body>
	</html>