<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head lang="en">
	<title>Payment Information</title>
	<meta charset="utf-8">
	<!-- CSS Start -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/payment.css">
	<!-- CSS End -->

	<!--JAVASCRITS STARST-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<!--JAVASCRIPT ENDS-->
<script>
function payment()
{
	alert("Payment done sucessfully");
	}
</script>
</head>
<body>
<%@include file = "header.jsp" %>
	<div class="container-fluid"><!-- Container Starts-->
		
		<div class="row"><!--div row starts-->
			<form action="payment.html">
			<div class="form_styling"><!-- Form starts -->
				<div class="col-md-offset-1 col-md-10"><!--Form Frame Starts-->
		
					<div class="row"><!--div row starts-->
						<div class="col-md-offset-5 col-md-4">
							<h3> Payment Details </h3>
						</div>
					</div><!--div row ends-->

					<div class="row top_spacing">
						<label class="col-md-offset-3 col-md-2 label_padding"> Card Holder's Name </label>
						<input type="text" class="col-md-3 input_box_styling" name="cardholder" tabindex="1" value="${card.cardHolder}">
					</div>

					<div class="row top_spacing">
						<label class="col-md-offset-3 col-md-2 label_padding">Card Number </label>
						<input type="text" class="col-md-3 input_box_styling" id="card_number" name="cardholder"  tabindex="2" value="${card.cardNo}">
					</div>

					<div class="row top_spacing">
						<label class="col-md-offset-3 col-md-2 label_padding"> Card Expiry Date </label>
						<input type="text" class="col-md-3 input_box_styling" name="month" tabindex="3" value="${card.expiryDate}">
						
					</div>
					
					<div class="row top_spacing">
						<label class="col-md-offset-3 col-md-2 label_padding"> Amount </label>
						<input type="text" class="col-md-3 input_box_styling" name="amount"  tabindex="4" value="${trip.cost}">
					</div>
					
					
						<input type="hidden" class="col-md-1 input_box_styling" name="tripId"  tabindex="5" value="${trip.tripId}">
						<input type="hidden" class="col-md-1 input_box_styling" name="userId"  tabindex="5" value="${trip.user.userId}">
						<input type="hidden" class="col-md-1 input_box_styling" name="messageId"  tabindex="5" value="${message.messageId}">
					<div class="row top_spacing">
						<input class="col-md-offset-6 col-md-1 btn btn-success" type="submit" value="Submit" onclick="payment()">
					</div>
				</div><!--Form Frame Ends-->
			</div><!-- Form ends -->
			</form>
		</div><!--div row ends-->

	</div>
</body>
</html>