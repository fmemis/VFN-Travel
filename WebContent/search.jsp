	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
		
		<link rel="stylesheet" href="/AirBnb2/css/search.css" type="text/css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
			function toggleChevron(e) {
				$(e.target)
					.prev('.panel-heading')
					.find("i.indicator")
					.toggleClass('fa-caret-down fa-caret-right');
			}
			$('#accordion').on('hidden.bs.collapse', toggleChevron);
			$('#accordion').on('shown.bs.collapse', toggleChevron);
		</script>
		<script>
		$(function(){
		  $("#NavBar").load("NavBar.jsp");
		});
		</script>

	</head>
	<body>
	<div id = "NavBar"></div>
	<div class="container">
		<div class="col-md-4 col-lg-4">
			<br><br>
			<form method="GET" action="SearchFilters">
			<input name="City" value="${City }" type="hidden">
			<input name="arrival" value="${arrival }" type="hidden">
			<input name="departure" value="${departure }" type="hidden">
			<input name="guests" value="${guests }" type="hidden">
			<div class="container-fluid">
				<div class="row">
					<!-- <div class="col-xs-8 col-sm-6"> -->
					<div id="accordion" class="panel panel-primary behclick-panel">
						<div class="panel-heading">
							<h3 class="panel-title">Search Filters</h3>
						</div>
						<div class="panel-body" >
							<div class="panel-heading " >
								<h4 class="panel-title">
									<a data-toggle="collapse" href="#collapse0">
										<i class="indicator fa fa-caret-down" aria-hidden="true"></i> Price
									</a>
								</h4>
							</div>
							<div id="collapse0" class="panel-collapse collapse in" >
								<ul class="list-group">
									<li class="list-group-item">
										<div class="checkbox">
											<label>
												<input type="checkbox" value="1" name="price1" ${pr1 == 'a' ? 'checked' : ''}>
												<input type="hidden" name="price1" value="0" />
												0 - 100$
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox" >
											<label>
												<input type="checkbox" name="price2" value="1" ${pr2 == 'a' ? 'checked' : ''}>
												<input type="hidden" name="price2" value="0" />
												100$ - 150$
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="price3" value="1" ${pr3 == 'a' ? 'checked' : ''}>
												<input type="hidden" name="price3" value="0" />
												150$ - 200$
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="price4" value="1" ${pr4 == 'a' ? 'checked' : ''}>
												<input type="hidden" name="price4" value="0" />
												200$ - 300$
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="price5" value="1" ${pr5 == 'a' ? 'checked' : ''}>
												<input type="hidden" name="price5" value="0" />
												300$ - 500$
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="price6" value="1" ${pr6 == 'a' ? 'checked' : ''}>
												<input type="hidden" name="price6" value="0" />
												500$ - 1000$
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="price7" value="1" ${pr7 == 'a' ? 'checked' : ''}>
												<input type="hidden" name="price7" value="0" />
												more than 1000$
											</label>
										</div>
									</li>
								</ul>
							</div>

							<div class="panel-heading " >
								<h4 class="panel-title">
									<a data-toggle="collapse" href="#collapse1">
										<i class="indicator fa fa-caret-down" aria-hidden="true"></i> Features
									</a>
								</h4>
							</div>
							<div id="collapse1" class="panel-collapse collapse in" >
								<ul class="list-group">
									<li class="list-group-item">
										<div class="checkbox">
											<label>
												<input type="checkbox" name="wifi" value="1" ${wi == 'a' ? 'checked' : ''}>
												<input type="hidden" name="wifi" value="0" />
												Free wifi
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox" >
											<label>
												<input type="checkbox" name="aircondition" value="1" ${airc == 'a' ? 'checked' : ''}>
												<input type="hidden" name="aircondition" value="0" />
												Air conditioning
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="heating" value="1" ${heat == 'a' ? 'checked' : ''}>
												<input type="hidden" name="heating" value="0" />
												Heating
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="parking" value="1" ${park == 'a' ? 'checked' : ''}>
												<input type="hidden" name="parking" value="0" />
												Parking
											</label>
										</div>
									</li>
								</ul>
							</div>
							<div class="panel-heading" >
								<h4 class="panel-title">
									<a data-toggle="collapse" href="#collapse3"><i class="indicator fa fa-caret-down" aria-hidden="true"></i> Property type</a>
								</h4>
							</div>
							<div id="collapse3" class="panel-collapse collapse in">
								<ul class="list-group">
									<li class="list-group-item">
										<div class="checkbox">
											<label>
												<input type="checkbox" name="hotel" value="1" ${hot == 'a' ? 'checked' : ''}>
												<input type="hidden" name="hotel" value="0" />
												Hotel
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox" >
											<label>
												<input type="checkbox" name="apartment" value="1" ${apart == 'a' ? 'checked' : ''}>
												<input type="hidden" name="apartment" value="0" />
												Apartment
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="villa" value="1" ${vil == 'a' ? 'checked' : ''}>
												<input type="hidden" name="villa" value="0" />
												Villa
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="studio" value="1" ${st == 'a' ? 'checked' : ''}>
												<input type="hidden" name="studio" value="0" />
												Studio
											</label>
										</div>
									</li>
									<li class="list-group-item">
										<div class="checkbox"  >
											<label>
												<input type="checkbox" name="bungalow" value="1" ${bung == 'a' ? 'checked' : ''}>
												<input type="hidden" name="bungalow" value="0" />
												Bungalow
											</label>
										</div>
									</li>
								</ul>
							</div>
							
						</div>
					</div>
					<!-- </div> -->
				</div>
			</div>
			 <button class="subscribe btn btn-primary btn-lg btn-block" type="submit">Search</button>
			</form>
		</div>
		<div class="col-md-8 col-lg-8">
			<div class="container">

				<hgroup class="mb20">
					<h1>Search Results</h1>
				</hgroup>
				<c:forEach items="${searchResults}" var="listing" varStatus="count">
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
							</ul>
							<ul id="menu">
								<li> &nbsp;<c:out value="${listing.bedsNumber}" /> &nbsp; &nbsp; &nbsp; &nbsp; </li>
								<li> &nbsp; &nbsp;<c:out value="${listing.bathsNumber}" /> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</li>
								<li> &nbsp; &nbsp; &nbsp;<c:out value="${listing.roomsNumber}" /> &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;</li>
								<li><c:out value="${listing.size}" /></li>
							</ul>
							<br>
							<div style="font-size:125%"><c:out value="${listing.dailyPrice}" /> avg/night	&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							Reviews&nbsp;<c:out value="${listing.getReviews().size()}" />&nbsp;&nbsp;
							<c:choose>
								<%-- <c:when test="${listing.reviewsAvgScore == '0'}" >
									No reviews yet
								</c:when>  --%>
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
				<c:if test="${prevPage}">
				<a class="link1" href="
					${pageContext.request.contextPath}/SearchFilters?City=${param.City}&arrival=${param.arrival}&departure=${param.departure}&guests=${param.guests}&page=${currentPage-1}&price1=${options.price1}&price2=${options.price2}&price3=${options.price3}&price4=${options.price4}&price5=${options.price5}&price6=${options.price6}&price7=${options.price7}&wifi=${options.wifi}&aircondition=${options.aircondition}&heating=${options.heating}&parking=${options.parking}&studio=${options.studio}&villa=${options.villa}&hotel=${options.hotel}&apartment=${options.apartment}&bungalow=${options.bungalow}">
					Previous Page
				</a>
			</c:if>
			<c:if test="${nextPage}">
				<a class="link1" href="
					${pageContext.request.contextPath}/SearchFilters?City=${param.City}&arrival=${param.arrival}&departure=${param.departure}&guests=${param.guests}&page=${currentPage+1}&price1=${options.price1}&price2=${options.price2}&price3=${options.price3}&price4=${options.price4}&price5=${options.price5}&price6=${options.price6}&price7=${options.price7}&wifi=${options.wifi}&aircondition=${options.aircondition}&heating=${options.heating}&parking=${options.parking}&studio=${options.studio}&villa=${options.villa}&hotel=${options.hotel}&apartment=${options.apartment}&bungalow=${options.bungalow}">
					Next Page
				</a>
			</c:if>

			</div>
		</div>
	</div>
	</body>
	</html>