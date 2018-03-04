    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>
    <head>
    <link rel="stylesheet" href="/AirBnb2/css/profile.css" type="text/css">
     <link rel="stylesheet" href="/AirBnb2/css/providerprofile.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <title>Provider profile</title>
    


    <script src="jquery.js"></script>
        <script>
        $(function(){
          $("#NavBar").load("NavBar.jsp");
        });
        </script>

    </head>
    <body>


    <div id= "NavBar"></div>
    <!--search box-->
    <div class="container">
      <!-- Modal -->
      <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">×</button>
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
          <li>
              <a href="#profile" role="tab" data-toggle="tab">
                  <i class="fa fa-book"></i> History
              </a>
          </li>
          <li><a href="#change" role = "tab" data-toggle="tab">
              <i class="fa fa-key"></i> Edit Profile
              </a>
          </li>
           <li><a href="#addroom" role = "tab" data-toggle="tab">
              <i class="fa fa-bed"></i> Add room
              </a>
          </li>
           <li><a href="UsersMessageServlet" >
              <i class="fa fa-envelope"></i> My Messages
              </a>
          </li>
          <li> <a  href="#ulist" role = "tab" data-toggle="modal">
              <i class="fa fa-bed"></i> My rooms
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

    <form class="form-horizontal main_form text-left" action="userprofile" method="post"  enctype="multipart/form-data" id="contact_form">
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
    <div role="tabpanel" class="tab-pane fade" id="addroom"><div class="container fom-main">
    <div class="row">
    <div class="col-sm-12">
    <h2 class="register">Add your room</h2>
    </div><!--col-sm-12 close-->

    </div><!--row close-->
    <br />
    <div class="row">

    <form class="form-horizontal main_form text-left" enctype="multipart/form-data" action="ProviderProfileServlet" method="post"  id="contact_form">
    <fieldset>


    <div class="form-group col-md-12">
      <label class="col-md-10 control-label">Address</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
      <input required="required" name="address" placeholder="Add the address of the room you want to add" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <!-- Text input-->


    <!-- Text input-->
           <div class="form-group col-md-12">
      <label class="col-md-10 control-label">Area</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input required="required" name="area" placeholder="Add the area your room is located" class="form-control"  type="text">
        </div>
      </div>
    </div>


    <!-- Text input-->

    <div class="form-group col-md-6">
      <label class="col-md-10 control-label">Baths</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input required="required" name="baths" placeholder="Number of Baths" class="form-control" type="text">
        </div>
      </div>
      </div>


    <!-- Text input-->

     <div class="form-group col-md-6" style = margin-left:15px;>
      <label class="col-md-10 control-label">Beds</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input required="required" name="beds" placeholder="Number of Beds" class="form-control" type="text">
        </div>
      </div>
    </div>


    <div class="form-group col-md-12">
      <label class="col-md-10 control-label">City</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input required="required" name="city" placeholder="Add the city your room is located" class="form-control" type="text">
        </div>
      </div>
    </div>



    <div class="form-group col-md-6">
      <label class="col-md-10 control-label">Daily Price</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input required="required" name="dprice" placeholder="Daily price required" class="form-control" type="text">
        </div>
      </div>
    </div>

    <div class="form-group col-md-6" style = margin-left:15px;>
      <label class="col-md-10 control-label">Size</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
      <input required="required"  name="size" placeholder="Write size in square meters" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <div class="form-group col-md-12" >
      <label class="col-md-10 control-label">Name</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
      <input required="required" name="name" placeholder="Give a Name" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <div class="form-group col-md-6">
      <label class="col-md-10 control-label">Latitude</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input  required="required" name="latitude" placeholder="Give coordinates" class="form-control" type="text">
        </div>
      </div>
    </div>

    <div class="form-group col-md-6" style = margin-left:15px;>
      <label class="col-md-10 control-label">Longtitude</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
      <input required="required" name="longtitude" placeholder="Give Coordinates" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <div class="form-group col-md-6">
      <label class="col-md-10 control-label">Max People</label>
        <div class="col-md-12 inputGroupContainer">
        <div class="input-group">
      <input required="required" name="maxp" placeholder="Give Maximum Number of People" class="form-control" type="text">
        </div>
      </div>
    </div>

    <div class="form-group col-md-6" style = margin-left:15px;>
      <label class="col-md-10 control-label">Max Rooms</label>
      <div class="col-md-12 inputGroupContainer">
      <div class="input-group">
      <input  required="required" name="roomsnumber" placeholder="Maximum Rooms Number" class="form-control"  type="text">
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
     <textarea name="description" cols="1000" rows="5" placeholder ="Describe the place you want to add" style = width:1125px;></textarea>
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
    </div><!--container close -->
    </div><!--tab-pane close-->
     </div>


      <div class="modal fade" id="ulist" style = "height:600px;">
      <div  class="modal-dialog">
      <div class="modal-content">
       <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title" style="background-color:#ffffff" >Listing List</h4>
        </div>
        <div class="modal-body">
     <c:forEach items="${listingl}" var="listing" varStatus="count">
                <section class="col-xs-12 col-sm-6 col-md-12">
                    <article class="search-result row">
                        <div class="col-xs-12 col-sm-12 col-md-3">
                            <c:choose>
                            <c:when  test="${listing.getImages().size()=='0'}" >
                                <a href="#" title="" class="thumbnail"><img src="" alt="" /></a>
                            </c:when>
                            <c:otherwise >
                                <a href="#" title="" class="thumbnail"><img src="image/${listing.getImages().get(0).photo}" alt="" /></a>
                            </c:otherwise>
                        </c:choose>
                        </div>
                        <!-- <div class="col-xs-12 col-sm-12 col-md-2">
                            <ul class="meta-search">
                                <li><i class="glyphicon glyphicon-calendar"></i> <span>02/15/2014</span></li>
                                <li><i class="glyphicon glyphicon-time"></i> <span>4:28 pm</span></li>
                                <li><i class="glyphicon glyphicon-tags"></i> <span>People</span></li>
                            </ul>
                        </div> -->
                        <%-- <%
                         session.setAttribute("listingid", "geia65");
                        %> --%>
                        <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                            <h3><a href="Listing?listingid=${listing.id.idlisting}&provname=${listing.user.username}&arrival=${param.arrival}&departure=${param.departure}" title="">${listing.name}</a></h3>
                            <ul id="menu">
                                <li>Beds&nbsp;</li>
                                <li>Bathrooms&nbsp;</li>
                                <li>Bedrooms&nbsp;</li>
                                <li>Size</li>
                                <li><a class="btn btn-large btn-warning" href="EditRoomServlet?param1=${listing.user.username}&param2=${listing.id.idlisting}">Edit</a></li>
                            </ul>
                            <ul id="menu">
                                <li> &nbsp;<c:out value="${listing.bedsNumber}" /> &nbsp; &nbsp; &nbsp; &nbsp; </li>
                                <li> &nbsp; &nbsp;<c:out value="${listing.bathsNumber}" /> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</li>
                                <li> &nbsp; &nbsp; &nbsp;<c:out value="${listing.roomsNumber}" /> &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;</li>
                                <li><c:out value="${listing.size}" /></li>
                            </ul>
                            <br>
                            <div style="font-size:125%"><c:out value="${listing.dailyPrice}" /> avg/night	&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <c:choose>
                                <c:when test="${listing.reviewsAvgScore == '0'}" >
                                    No reviews yet
                                </c:when>
                                <c:when  test="${listing.reviewsAvgScore >= '1' && listing.reviewsAvgScore < 1.5}" >
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:when>
                                <c:when  test="${listing.reviewsAvgScore >= '1.5' && listing.reviewsAvgScore < 2.5}" >
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:when>
                                <c:when test="${listing.reviewsAvgScore >= '2.5' && listing.reviewsAvgScore < 3.5}" >
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:when>
                                <c:when test="${listing.reviewsAvgScore >= '3.5' && listing.reviewsAvgScore < 4.5}" >
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:when>
                                <c:when test="${listing.reviewsAvgScore >= '4.5'}" >
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </c:when>
                            </c:choose>

                            </div>
                        </div>
                        <span class="clearfix borda"></span>
                    </article>



                </section>
                </c:forEach>
    </div>
     <div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></div>
    </div>
    </div>
    </div>



    </section><!--section close-->





    </body>
    </html>