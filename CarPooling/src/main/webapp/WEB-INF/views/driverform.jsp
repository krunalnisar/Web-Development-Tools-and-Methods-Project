<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Login Page</title>
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<title>Driver Details</title>
</head>
<body>
<div class="container">
		<center>
			<h1>Driver Details</h1>
		</center>
		<form:form commandName="driverdetails" action="driver.html" method="Post">


			<fieldset>
				<legend>License Details</legend>
				<div class="row">
					<div class="col-md-2">Driving License No:</div>
					<div class="col-md-4">
						<form:input path="licenseNo" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="licenseNo" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-2">Validity in months:</div>
					<div class="col-md-4">
						<form:input path="validity" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="validity" cssStyle="color:red"></form:errors>
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