<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#space{
	padding-bottom: 100px;
	}
</style>
<link href="resources/css/header.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Login Page</title>
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<title>User Enrollment Form</title>
<script>
	$(document).ready(function() {
		$("#username").keyup(function(event) {
			
			x = document.getElementById("myform").elements[1].value;
			//alert(x);
			$.ajax({
				url : 'ajaxservice.html',
				method : 'get',
				ContentType : 'json',
				
				data : {
					user : x
				},
				success:function(response)
				{
					$("result").css({
						'color' : 'red',
						'font-size' :'20px'
					});
					$("#result").html(response);
						
				}
			});
			
			
		
		});

	});
</script>
</head>
<body>

	<div id="space"></div>
	<div class="container">
		<center>
			<h1>USER ENROLLMENT FORM</h1>
		</center>
		<form:form id="myform" commandName="user" action="userform.html" method="Post" enctype="multipart/form-data">
			<fieldset>
				<legend>Login Details</legend>
				<div class="row">
					<div class="col-md-2">Username:</div>
					<div class="col-md-4">
						<form:input path="username" class="form-control" id="username" />
					</div><span id="result"></span>
					<div class="col-md-5">
						<form:errors path="username" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-2">Password:</div>
					<div class="col-md-4">
						<form:input path="password" class="form-control" id="pswd1" />
					</div>
					<div class="col-md-5">
						<form:errors path="password" cssStyle="color:#ff0000"></form:errors>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-2">Enter your password again:</div>
					<div class="col-md-4">
						<input class="form-control" name="pswd2" id="pswd2"  />
					</div>
					<div class="col-md-5">
						
					</div>
				</div>
				<br />
			</fieldset>

			<fieldset>
				<legend>Personal Details</legend>
				<div class="row">
					<div class="col-md-2">First Name:</div>
					<div class="col-md-4">
						<form:input path="name" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="name" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<br />
				
				<div class="row">
					<div class="col-md-2">Gender:</div>
					<div class="col-md-6">
						<label class="radio-inline"> <form:radiobutton
								path="gender" value="Male" /> Male
						</label> <label class="radio-inline"> <form:radiobutton
								path="gender" value="Female" /> Female
						</label>
					</div>
				</div>
				<br />
				
				<div class="row">
					<div class="col-md-2">Email Id:</div>
					<div class="col-md-4">
						<form:input path="email" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="email" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-2">Age:</div>
					<div class="col-md-4">
						<form:input path="age" class="form-control" />
					</div>
					<div class="col-md-5">
						<form:errors path="age" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-2">Upload Profile Image:</div>
					<div class="col-md-4">
						<input name="image" type="file" class="form-control" />
					</div>
					<div class="col-md-5">
						
					</div>
				</div>
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