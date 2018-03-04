  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html>
  <head>
  <link rel="stylesheet" href="/AirBnb2/css/profile.css" type="text/css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>Edit Room</title>
  <script src="jquery.js"></script>
      <script>
      $(function(){
        $("#NavBar").load("NavBar.jsp");
      });
      </script>
  </head>
  <body>

  <h2 class="register" style =  "margin-left:520px;">Edit your room</h2>
  </div><!--col-sm-12 close-->

  </div><!--row close-->
  <br />
  <div class="row">

  <form class="form-horizontal main_form text-left" action="EditRoomServlet" method="post"  id="contact_form" style = "margin-left:20px;">
  <input type="hidden"   name="username" value = <%= request.getAttribute("uname")%> placeholder=<%= request.getAttribute("uname")%>class="form-control"  type="text" style = "margin-bottom:10px;">
  <input type="hidden"   name="id" value = <%= request.getAttribute("id")%> placeholder=<%= request.getAttribute("id")%> class="form-control"  type="text" style = "margin-bottom:10px;">

  <fieldset>


  <div class="form-group col-md-12">
    <label class="col-md-10 control-label">Address</label>
    <div class="col-md-12 inputGroupContainer">
    <div class="input-group">
    <input  name="address" placeholder=<c:out value="${listing.adress}"/> class="form-control"  type="text">
      </div>
    </div>
  </div>

  <!-- Text input-->


  <!-- Text input-->
         <div class="form-group col-md-12">
    <label class="col-md-10 control-label">Area</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
    <input  name="area" placeholder=<c:out value="${listing.area}"/> class="form-control"  type="text">
      </div>
    </div>
  </div>


  <!-- Text input-->

  <div class="form-group col-md-6">
    <label class="col-md-10 control-label">Baths</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
    <input  name="baths" placeholder=<c:out value="${listing.bathsNumber}"/> class="form-control" type="text">
      </div>
    </div>
    </div>


  <!-- Text input-->

   <div class="form-group col-md-6" style = margin-left:15px;>
    <label class="col-md-10 control-label">Beds</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
    <input  name="beds" placeholder=<c:out value="${listing.bedsNumber}"/> class="form-control" type="text">
      </div>
    </div>
  </div>


  <div class="form-group col-md-12">
    <label class="col-md-10 control-label">City</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
    <input  name="city" placeholder=<c:out value="${listing.city}"/> class="form-control" type="text">
      </div>
    </div>
  </div>



  <div class="form-group col-md-6">
    <label class="col-md-10 control-label">Daily Price</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
    <input  name="dprice" placeholder<c:out value="${listing.dailyPrice}"/> class="form-control" type="text">
      </div>
    </div>
  </div>

  <div class="form-group col-md-6" style = margin-left:15px;>
    <label class="col-md-10 control-label">Size</label>
    <div class="col-md-12 inputGroupContainer">
    <div class="input-group">
    <input   name="size" placeholder=<c:out value="${listing.size}"/> class="form-control"  type="text">
      </div>
    </div>
  </div>

  <div class="form-group col-md-12" >
    <label class="col-md-10 control-label">Name</label>
    <div class="col-md-12 inputGroupContainer">
    <div class="input-group">
    <input  name="name" placeholder=<c:out value="${listing.name}"/> class="form-control"  type="text">
      </div>
    </div>
  </div>

  <div class="form-group col-md-6">
    <label class="col-md-10 control-label">Latitude</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
    <input   name="latitude" placeholder=<c:out value="${listing.latitude}"/> class="form-control" type="text">
      </div>
    </div>
  </div>

  <div class="form-group col-md-6" style = margin-left:15px;>
    <label class="col-md-10 control-label">Longtitude</label>
    <div class="col-md-12 inputGroupContainer">
    <div class="input-group">
    <input  name="longtitude" placeholder=<c:out value="${listing.longtitude}"/> class="form-control"  type="text">
      </div>
    </div>
  </div>

  <div class="form-group col-md-6">
    <label class="col-md-10 control-label">Max People</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
    <input  name="maxp" placeholder=<c:out value="${listing.maxPeople}"/> class="form-control" type="text">
      </div>
    </div>
  </div>

  <div class="form-group col-md-6" style = margin-left:15px;>
    <label class="col-md-10 control-label">Max Rooms</label>
    <div class="col-md-12 inputGroupContainer">
    <div class="input-group">
    <input   name="roomsnumber" placeholder=<c:out value="${listing.roomsNumber}"/> class="form-control"  type="text">
      </div>
    </div>
  </div>



  <label class="col-sm-12 control-label">Select room type</label>
  <select name="rtype" class="col-sm-12 control-label" style = "margin-left:15px; width:1110px;">
      <option value="1">Hotel</option>
      <option value="2">Apartment</option>
      <option value="3">Villa</option>
      <option value="4">Studio</option>
      <option value="5">Bungalow</option>
   </select>

  <div class="checks" style="margin-left:20px;">
  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="wifi">WiFi</label>
  <input type="hidden" name="wifi" value="0" />
  </div>

  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="aircondition">AirCondition</label>
  <input type="hidden" name="aircondition" value="0" />
  </div>

  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="elevator">Elevator</label>
  <input type="hidden" name="elevator" value="0" />
  </div>

  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="heat">Heating</label>
  <input type="hidden" name="heat" value="0" />
  </div>

  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="tv">TV</label>
  <input type="hidden" name="tv" value="0" />
  </div>

  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="kitchen">Kitchen</label>
  <input type="hidden" name="kitchen" value="0" />
  </div>

  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="parking">Parking</label>
  <input type="hidden" name="parking" value="0" />
  </div>

  <div class="form-group col-md-6">

  <label class="checkbox-inline"><input type="checkbox" value="1" name="pets">Pets</label>
  <input type="hidden" name="pets" value="0" />
  </div>
  </div>
  <div class="form-group col-md-12">
    <label class="col-md-10 control-label">Description</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group" >
   <textarea name="description" cols="1000" rows="5" placeholder =<c:out value="${listing.description}"/> style = width:1125px;></textarea>
      </div>
    </div>
  </div>





  <!-- upload profile picture -->
  <div class="col-md-12 text-left">
  <div class="uplod-picture">
  <span class="btn btn-default uplod-file">
      Upload Photos(Up to 6)) <input type="file" name="uploadingFiles" multiple>
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
  </body>
  </html>