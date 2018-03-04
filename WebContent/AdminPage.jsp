    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/AirBnb2/css/profile.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script> -->

    <title>Admin profile</title>

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
          <li>
              <a href="#profile" role="tab" data-toggle="tab">
                  <i class="fa fa-book"></i> History
              </a>
          </li>
          <li><a href="#change" role = "tab" data-toggle="tab">
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
         <tr>
            <td>Trn</td>
             <td><c:out value="${user.trn}"/></td>
        </tr>

        </tbody>
      </table>
      </div><!--table-responsive close-->
    </div><!--col-md-6 close-->
    </div>
    </div>

    <ul class="nav nav-tabs" role="tablist">
     </ul>

      <!-- Tab panes -->

        <div role="tabpanel" class="tab-pane fade " id="change"><div class="container fom-main">
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

    <div class="form-group col-md-12">
      <label class="col-md-10 control-label">Trn</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input name="trn" placeholder=<c:out value="${user.trn}"/> class="form-control" type="text">
        </div>
      </div>
    </div>


    <!-- Select Basic -->




    <!--<div class="form-group col-md-12">
      <label class="col-md-10 control-label">Project Description</label>
        <div class="col-md-10 inputGroupContainer">
        <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-pencil hint_icon"></i></span>
                <textarea class="form-control" name="comment" placeholder="Project Description"></textarea>
      </div>
      </div>
    </div>-->


    <div class="form-group col-md-12">
      <label class="col-md-10 control-label">Choose Password</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
      <input  name="pass" placeholder="Choose Password" class="form-control"  type="password">
        </div>
      </div>
    </div>



    <div class="form-group col-md-12">
      <label class="col-md-10 control-label">Confirm Password</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
      <input  name="pass" placeholder="Confirm Password" class="form-control"  type="password">
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
    <div class = "adop">
    <div class="col-md-6">
        <h3 style = margin-left:75px;>view user list</h3>
    </div>
    <div class="col-md-6">
        <h3 style = margin-left:25px>download app details</h3>
    </div>
    <div class="col-md-6" style = margin-bottom:100px;>
        <a id="user" class="btn btn-default" data-toggle="modal" href="#ulist"></a>
    </div>
    <div class="col-md-6">
        <a id="folder" class="btn btn-default" href = "WriteFileServlet" style = margin-bottom:100px; ></a>
    </div>
    </div>

     <div class="modal fade" id="ulist" style = "height:600px;">
      <div  class="modal-dialog">
      <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title" style="background-color:#ffffff" >Users List</h4>
        </div>

     <div class="modal-body">
         <ul class="list-group">
          <c:forEach var="team" items="${users}">
           <li class = "list-group-item"><a href= "ViewProfileServlet?param1=${team.username}">${team.username} </a>
                <c:if test="${team.trn ne null}">
                <c:if test="${team.type eq 1}">
                    <a class="btn btn-large btn-warning" href="AcceptProviderServlet?param1=${team.username}">Accept</a>
                    </c:if>
                </c:if>
           </li>
         </c:forEach>
    </ul>
    </div>
     <div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></div>
    </div>
    </div>
    </div>
    </body>
    </html>