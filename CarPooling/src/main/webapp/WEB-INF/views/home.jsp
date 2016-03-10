<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Welcome to Carpool</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<!-- CSS Start -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/home.css">
	<!-- CSS End -->
	<link href="resources/css/login.css" rel="stylesheet">

	
	
	
</head>
<body>
<div class="container">
	<section id="content">
		<form action="login.html" method="post">
			<h1>Login Form</h1>
			<div>
				<input type="text" placeholder="Username" required id="username" name="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" required id="password" name="password"/>
			</div>
			<div>
				<input type="submit" value="Log in" />
			</div>
		</form><!-- form -->
		<span><a href="register.html"><button>Register</button></a>
		<a href="guest.html"><button>Guest</button></a></span>
		
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
