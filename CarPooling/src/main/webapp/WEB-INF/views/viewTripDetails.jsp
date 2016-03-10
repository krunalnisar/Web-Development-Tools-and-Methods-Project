<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/header.css" rel="stylesheet">
<link href="resources/css/table.css" rel="stylesheet">
<style type="text/css">
img{
width:200px;
height:200px;
border:10px solid red;
}
</style>
</head>
<body>
<h1>View Trip Details</h1>
			<table>
				<tr>
					<td rowspan="2"><img src="${user.imageFile}" alt="sorry no image found"></td>
					<td colspan="2">${trip.user.name}</td>
				</tr>
				
				<tr>
					<td>${trip.user.gender}</td>
					<td>${trip.user.status}</td>
				</tr>
			</table>
			<hr/>
			<table>
				<tr>
					<td rowspan="2">${trip.time }</td>
					<td colspan="2"><p>Source : ${trip.sourceId.places}</p>
					 	<p>Destination : ${trip.destinationId.places}</p> 
					 
					 </td>
				</tr>
				
				<tr>
					<td>Miles : ${trip.miles}</td>
					<td>Cost : ${trip.cost}</td>
				</tr>
			</table>
			<hr/>
			<table>
				<tr>
					<td rowspan="2"><img src="${trip.user.car.imageFile}" alt="sorry no image found"></td>
					<td colspan="2">${trip.user.car.name}</td>
				</tr>
				
				<tr>
					<td> Capacity : ${trip.user.car.capacity}</td>
					<td>Model No : ${trip.user.car.modelNo}</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>SEND REQUEST</td>
					<td><a href="requestaride.html?tripId=${trip.tripId}&reciever=${trip.user.name}&source=${trip.sourceId.places}&destination=${trip.destinationId.places}"><button>Request</button></a></td>
				</tr>
				
				
			</table>
			
			
	
</body>
</html>