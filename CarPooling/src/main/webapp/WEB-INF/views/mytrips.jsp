<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>My Trips</title>
<link rel="stylesheet" type="text/css" href="resources/css/mytrips.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/bootflat.css">
   
  <style type="text/css">
  #space{
  padding-top: 70px;
  }
  </style>


</head>
<body>
<%@include file = "header.jsp" %>
<div id="space"></div>
<c:forEach var="trip" items="${tripList}">
<div class="timeline">
						
						  <dl>
						 
						  <c:if test="${trip.tripId % 2 == 1}">
							  <dt>${trip.startDate}</dt>
							  <dd class="pos-left clearfix">
								  <div class="circ"></div>
								  <div class="time"></div>
								  <div class="events">
									 
									  <div class="events-body">
										  <h4 class="events-heading">${trip.sourceId.places} to ${trip.destinationId.places}</h4>
										 <h4>INITIATED BY  : ${trip.user.name}</h4>
										  <h4>TIME : ${trip.time}</h4>
										  <h4>Miles :${trip.miles} </h4>
										  <h4>Cost :${trip.cost} </h4>
									  </div>
								  </div>
							  </dd>
							  </c:if>
							  
							  	 
							  <c:if test="${trip.tripId % 2 == 0}">
							  <dt>${trip.startDate}</dt>
							  <dd class="pos-right clearfix">
								  <div class="circ"></div>
								  <div class="time"></div>
								  <div class="events">
									  
									  <div class="events-body">
										  <h4 class="events-heading">${trip.sourceId.places} to ${trip.destinationId.places}</h4>
										 <h4>INITIATED BY  : ${trip.user.name}</h4>
										  <h4>TIME : ${trip.time}</h4>
										  <h4>Miles :${trip.miles} </h4>
										  <h4>Cost :${trip.cost} </h4>
									  </div>
								  </div>
							  </dd>
							  </c:if>
						</dl>
</div>
</c:forEach>
</body>
</html>