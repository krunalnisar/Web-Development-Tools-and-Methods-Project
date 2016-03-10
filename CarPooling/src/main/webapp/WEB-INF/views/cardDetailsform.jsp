<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<title>Login Page</title>
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
</head>
<body>
<center>
            <h1>Payment Details</h1>
        </center>
    <div class="container">
        
        <form:form commandName="cardDetails" action="cardDetails.html" method="Post">


            <fieldset>
                <legend></legend>
                <div class="row">
                    <div class="col-md-2">Card Holder Name:</div>
                    <div class="col-md-4">
                        <form:input path="cardHolder" class="form-control" />
                    </div>
                    <div class="col-md-5">
                        <form:errors path="cardHolder" cssStyle="color:red"></form:errors>
                    </div>
                </div>
                <br />
                
                <div class="row">
                    <div class="col-md-2">Card Number:</div>
                    <div class="col-md-4">
                        <form:input path="cardNo" class="form-control" />
                    </div>
                    <div class="col-md-5">
                        <form:errors path="cardNo" cssStyle="color:red"></form:errors>
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-md-2">Expiry date:</div>
                    <div class="col-md-4">
                        <input type="date" name="expiryDate" class="form-control" required="required"/>
                    </div>
                    <div class="col-md-5">
                        
                    </div>
                </div>


            </fieldset>
            <br />
            <div class="row">
                <div class="col-md-2">
                    <input type="submit" value="Submit" class="btn btn-submit" />
                </div>
            </div>



        </form:form>
    </div>
</body>
</html>