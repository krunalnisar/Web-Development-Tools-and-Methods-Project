<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="resources/css/header.css" rel="stylesheet">
<link href="resources/css/table.css" rel="stylesheet">
<link href="resources/css/search.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>


<script>
function mapplot() {


	var locations = [];

	var x;
	var y;
	var z;
	var size=(document.getElementById("size").value);
	//alert(size);
	
	for (var i = 0; i <= size; i++) {
		x = document.getElementById('lat' +i).value;
		y = document.getElementById('lon' +i).value;
		z = document.getElementById('addr' +i).value;
		u = document.getElementById('user' +i).value;
		//alert(x);
		//alert(y);
		//alert(z);
		
		locations[i] = [];
		locations[i][0] = z;
		locations[i][1] = x;
		locations[i][2] = y;
		locations[i][3] = u;
	}



	var map = new google.maps.Map(document.getElementById('map-canvas'), {
		zoom : 12,
		center : new google.maps.LatLng(locations[0][1], locations[0][2]),
		//center : new google.maps.LatLng(42.2732, -71.324324),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});
	var infowindow = new google.maps.InfoWindow();
	var marker, i;
	for (i = 0; i < locations.length; i++) {
		//alert(locations.length);
		marker = new google.maps.Marker({
			position : new google.maps.LatLng(locations[i][1],
					locations[i][2]),
			map : map
		});
		google.maps.event.addListener(marker, 'click',
				(function(marker, i) {
					return function() {
						infowindow.setContent(locations[i][3]+" : "+locations[i][0]);
						infowindow.open(map, marker);
					}
				})(marker, i));
	}
}
</script>

<script>
function initialize() {
	var address = (document.getElementById('source'));
	var address1 = (document.getElementById('destination'));
	var autocomplete = new google.maps.places.Autocomplete(address);
	var autocomplete1 = new google.maps.places.Autocomplete(address1);
	autocomplete.setTypes([ 'geocode' ]);
	google.maps.event
			.addListener(
					autocomplete,
					'place_changed',
					function() {
						var place = autocomplete.getPlace();
						if (!place.geometry) {
							return;
						}
						autocomplete1.setTypes([ 'geocode' ]);
						google.maps.event
								.addListener(
										autocomplete1,
										'place_changed',
										function() {
											var place = autocomplete1
													.getPlace();
											if (!place.geometry) {
												return;
											}
											var address = '';
											if (place.address_components) {
												address = [
														(place.address_components[0]
																&& place.address_components[0].short_name || ''),
														(place.address_components[1]
																&& place.address_components[1].short_name || ''),
														(place.address_components[2]
																&& place.address_components[2].short_name || '') ]
														.join(' ');
											}
										});
						//alert("zip:"+ place.address_components[7].short_name );
						var address1 = '';
						if (place.address_components) {
							address1 = [
									(place.address_components[0]
											&& place.address_components[0].short_name || ''),
									(place.address_components[1]
											&& place.address_components[1].short_name || ''),
									(place.address_components[2]
											&& place.address_components[2].short_name || '') ]
									.join(' ');
						}
					});
}
function codeAddress() {
	geocoder = new google.maps.Geocoder();
	var address = document.getElementById("source").value;
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			//  alert("Latitude: "+results[0].geometry.location.lat());
			//alert("Longitude: "+results[0].geometry.location.lng());
			fromlat = parseFloat(results[0].geometry.location.lat());
			fromlong = parseFloat(results[0].geometry.location.lng());
			document.getElementById("slat").setAttribute("value",fromlat);
			document.getElementById("slon").setAttribute("value",fromlong);
			//alert("start point set");
		}
		else {
			alert("Geocode was not successful for the following reason1: "
					+ status);
		}
	});
}
function codeAddress1() {
	geocoder = new google.maps.Geocoder();
	var address = document.getElementById("destination").value;
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			//   alert("Latitude: "+results[0].geometry.location.lat());
			//  alert("Longitude: "+results[0].geometry.location.lng());
			tolat = parseFloat(results[0].geometry.location.lat());
			tolong = parseFloat(results[0].geometry.location.lng());
			document.getElementById("dlat").setAttribute("value", tolat);
			document.getElementById("dlon")
					.setAttribute("value", tolong);
			//alert("endpoint set");
		}
		else {
			alert("Geocode was not successful for the following reason2: "
					+ status);
		}
	});
}
google.maps.event.addDomListener(window, 'load', initialize);
function mapLocation() {
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var map;
	function initialize1() {
		directionsDisplay = new google.maps.DirectionsRenderer();
		if (window.navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(success);
		} else if (!window.navigator.geolocation) {
			var inilat = 43.3333333;
			var inilong = (-71.345543);
		}
		else {
			alert("Map initialization failed!!!")
		}
		function success(pos) {
			var inilat = (parseFloat(pos.coords.latitude));
			var inilong = (parseFloat(pos.coords.longitude));
			alert((inilat) + " " + (inilong));
			var mapcenter = new google.maps.LatLng(inilat, inilong);
			//var fromloc = new google.maps.LatLng(fromlat,fromlong);
			var mapOptions = {
				zoom : 10,
				//center: fromloc
				center : mapcenter
			};
			map = new google.maps.Map(
					document.getElementById('map-canvas'), mapOptions);
			directionsDisplay.setMap(map);
		}
		google.maps.event.addDomListener(document
				.getElementById('destination'), 'blur', calcRoute);
	}
	function calcRoute() {
		var start = new google.maps.LatLng(fromlat, fromlong);
		//var start = new google.maps.LatLng(37.334818, -121.884886);
		//var end = new google.maps.LatLng(37.441883, -122.143019);
		var end = new google.maps.LatLng(tolat, tolong);
		var request = {
			origin : start,
			destination : end,
			travelMode : google.maps.TravelMode.DRIVING
		};
		directionsService
				.route(request,
						function(response, status) {
							if (status == google.maps.DirectionsStatus.OK) {
								directionsDisplay.setDirections(response);
								directionsDisplay.setMap(map);
							} else {
								alert("Directions Request from "
										+ start.toUrlValue(6) + " to "
										+ end.toUrlValue(6) + " failed: "
										+ status);
							}
						});
	}
	//alert("test"+document.getElementById('my-address'));
	google.maps.event.addDomListener(window, 'load', initialize1);
}
mapLocation();


</script>

</head>
<body>
	
	<div id="container">

		<form method="get" action="search.html">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2">
					<div class="input-group">
						<h3>Source</h3>
					</div>
				</div>

				<div class="col-md-2">
					<div class="input-group">
						<h3>Destination</h3>
					</div>
				</div>


				<div class="col-md-4"></div>
			</div>


			<div class="row">
				<div class="col-md-4"></div>

				<div class="col-md-2">
					<div class="input-group">
						<input type="text" class="form-control" id="source"
							onblur="codeAddress()" required> <input type="hidden" name="slat"
							id="slat" value="" /> <input type="hidden" name="slon" id="slon"
							value="" />
					</div>
				</div>

				<div class="col-md-2">
					<div class="input-group">
						<input type="text" class="form-control" id="destination"
							onblur="codeAddress1()" required> <input type="hidden" name="dlat"
							id="dlat" value="" /> <input type="hidden" name="dlon" id="dlon"
							value="" />
					</div>

				</div>

				
			</div>
		

		<div class="row">
			<div class="col-md-4"></div> 
			
				<div class="col-md-1">
   					 <select class="selectpicker form-control"  data-width="auto" name="radius">

					  <option value="1">1</option>
					   <option value="2">2</option>
					    <option value="3">3</option>
					     <option value="5">5</option>
					      <option value="10">10</option>
					       <option value="20">20</option>
					        <option value="40">40</option>
					         <option value="60">60</option>
					          <option value="80">80</option>
					           <option value="100">100</option>
					            <option value="200">200</option>
					            	<option value="400">400</option>
					  					<option value="800">800</option>
					 						
					  
					</select>
				
			</div>	
			<div class="col-md-1">

					<input class="btn btn-info btn-lg" type="submit" name="submit"
						id="routebtn" value="search" />
				
			</div>
			
			<div class="col-md-1">
				 <input
						class="btn btn-info btn-lg" type="button" name="map"
						value="Plot On Map" onclick="mapplot()" />
			</div>
		</div>
		</form>
		
		<div class="row map">
			<div id="map-canvas"></div>
			
		</div>

		<c:if test="${not empty tripList}">
		<div class="row">
			<table>
			
				<tr>
					<th>Name</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Cost</th>
					<th>Available Seats</th>
					<th>Status</th>
				

				</tr>

				
				<c:forEach var="i" begin="0" end="${size}" step="1">
					<tr>

						<td>${tripList[i].user.name}</td>
						<td>${tripList[i].sourceId.places}</td>
						<td>${tripList[i].destinationId.places}</td>
						<td>${tripList[i].cost}</td>
						<td>${tripList[i].availableSeats}</td>
						<td>${tripList[i].status}</td>
						

					</tr>
						<input type="hidden" id="user${i}" value="${tripList[i].user.name}" />
						<input type="hidden" id="lat${i}" value="${tripList[i].sourceId.latitude}" />
						<input type="hidden" id="lon${i}" value="${tripList[i].sourceId.longitude}" />
						<input type="hidden" id="addr${i}" value="${tripList[i].sourceId.places}" />
						<input type="hidden" id="size" value="${size}" />
				</c:forEach>
			
			</table>
		</div>
		</c:if>
	</div>
	<!-- Container Div  -->
</body>
</html>