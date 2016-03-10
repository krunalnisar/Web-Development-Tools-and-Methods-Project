<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->

<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=places"></script>
<script src="resources/js/googleapi.js"></script>
</head>
<body>
	<%@include file="session.jsp"%>
	<%@include file="header.jsp"%>
	<div id="space"></div>
	<div class="container">
		<h1>Post a trip</h1>
		<h4>Enter the details</h4>
		<br />
		<form method="post" action="submittrip.html">
			<div class="row">
				<div class="col-md-2">Source:</div>
				<div class="col-md-4">
					<input class="form-control" type="text" id="sourceid"
						name="sourceid" required onblur="codeAddress()" />
				</div>
				<div class="col-md-4">
					<p id="sid"></p>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-2">Destination:</div>
				<div class="col-md-4">
					<input class="form-control" type="text" id="destid" name="destid"
						required onblur="codeAddress1()" />
				</div>
				<div class="col-md-4">
					<p id="did"></p>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-2">Start Date:</div>
				<div class="col-md-4">
					<input type='date' class="form-control" name="startdate" required value="yyyy-dd-mm" />
				</div>
				<div class="col-md-4">
					<p id="sdateerr"></p>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-2">End Date:</div>
				<div class="col-md-4">
					<input type='date' class="form-control" name="enddate" required value="yyyy-dd-mm"/>
				</div>
				<div class="col-md-4">
					<p id="edateerr"></p>
				</div>
			</div>
<br/>
			<div class="row">
				<div class="col-md-2">Trip Time:</div>
				<div class="col-md-4">
					<input id="timepicker1" type="time" class="form-control" required value="hh:mm:ss"
						name="triptime">
				</div>
				<div class="col-md-4">
					<p id="tterr"></p>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-2">Cost per seat:</div>
				<div class="col-md-4">
					<input id="cost" name="cost" type="text" required class="form-control">
				</div>
				<div class="col-md-4">
					<p id="costerr"></p>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-2">Capacity:</div>
				<div class="col-md-4">
					<input id="capacity" name="capacity" required type="text"
						class="form-control">
				</div>
				<div class="col-md-4">
					<p id="capacityerr"></p>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-2">Comments:</div>
				<div class="col-md-4">
					<textarea id="comments" name="comments" required class="form-control"></textarea>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-2">
					<input type="submit" value="Create Trip" class="btn btn-default" />
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-2">
					<input type="reset" value="Clear Form" class="btn btn-default" />
				</div>
				<input type="hidden" id="slat" name="slat" value="" /> <input
					type="hidden" id="slong" name="slong" value="" /> <input
					type="hidden" id="dlat" name="dlat" value="" /> <input
					type="hidden" id="dlong" name="dlong" value="" />
			</div>
		</form>
	</div>
</body>
</html>