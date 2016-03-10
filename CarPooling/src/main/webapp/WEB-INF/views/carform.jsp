<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#space{
	padding-bottom: 100px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Login Page</title>
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<title>Car Details</title>
</head>
<body>
<div id="space"></div>
<div class="container">
		<center>
			<h1>Car Details</h1>
		</center>
		<form:form commandName="car" action="car.html" method="Post" enctype="multipart/form-data">


			<fieldset>
				<legend>Car Details</legend>
				<div class="row">
					<div class="col-md-2">Car Name:</div>
					<div class="col-md-4">
						<form:input path="name" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="name" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-2">Car Color:</div>
					<div class="col-md-4">
						<form:input path="color" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="color" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-2">Car Model:</div>
					<div class="col-md-4">
						<form:input path="modelNo" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="modelNo" cssStyle="color:red"></form:errors>
					</div>
				</div>

				<br />
				<div class="row">
					<div class="col-md-2">Car Capacity:</div>
					<div class="col-md-4">
						<form:input path="capacity" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="capacity" cssStyle="color:red"></form:errors>
					</div>
				</div>


				<br />
				<div class="row">
					<div class="col-md-2">Upload Image of Car:</div>
					<div class="col-md-4">
						<input name="image" type="file"/>
					</div>
					<div class="col-md-5">
			
					</div>
				</div>

				<br />
								
			</fieldset>
			<br />
			<div class="row">
				<div class="col-md-2">
					<input type="submit" value="Next>>" class="btn btn-submit" />
				</div>
			</div>



		</form:form>
	</div>
</body>
</html>