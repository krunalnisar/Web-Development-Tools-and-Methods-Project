<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#space{
	padding-bottom: 100px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/header.css" rel="stylesheet">
<link href="resources/css/table.css" rel="stylesheet">
</head>
<body>
<%@include file = "header.jsp" %>
<div id="space"></div>
<c:set var="username" scope="session" value="${username}"/>

<table border ="1">
        <tr>
            <th>Message ID</th>
            <th>Sender</th>
            <th>Reciever</th>
            <th>Messages</th>
            <th>Date</th>
             <th>Status</th>
             <th>Delete</th>
        </tr>
        
        
	<c:forEach var="message" items="${messageList}">
	 <tr>       
            	<td>${message.messageId}</td>
            	<td>${message.sender}</td>
            	<td>${message.reciever}</td>
            	<td>${message.messages}</td>
                <td>${message.date}</td>
                
                	<c:if test="${message.sender == username}">
                		<c:choose>
						    <c:when test="${message.status == 'pending'}">
						       <td>Status Pending</td>
						    </c:when>
						    <c:when test="${message.status == 'approved'}">
						       	<td><a href="confirmpayment.html?tripId=${message.trip.tripId}&userId=${user.userId}&messageId=${message.messageId}"><button>Payment</button></a></td>
						    </c:when>
						     <c:when test="${message.status == 'reject'}">
						       	<td>reject</td>
						    </c:when>
						    <c:when test="${message.status == 'paymentdone'}">
						    <td>Payment Confirmed</td>
						    </c:when>
						    
						 </c:choose>
					</c:if>
					
					<c:if test="${message.reciever == username}">
					<c:choose>
						<c:when test="${message.status == 'approved'}">
						       	<td>Approved</td>
						</c:when>
						<c:when test="${message.status == 'rejected'}">
						       	<td>Rejected</td>
						</c:when>
				    	<c:otherwise>
				         <td><a href="approve.html?messageId=${message.messageId}"><button>Approved</button></a>
                		 <a href="reject.html?messageId=${message.messageId}"><button>Rejected</button></a></td>
				   		 </c:otherwise>
				    </c:choose>
               		</c:if>
                <td><input type="checkbox" name="delete" value="${message.messageId}"> delete</td>
               
     </tr>  
	</c:forEach>
	 <tr>
     			<td colspan="7"> you have "${count}" messages"</td>
    </tr>
    <tr>
     			<td colspan="7"><input type="submit" name="submit" value="Delete Selected Message"/></td>
    </tr>
</table>

</body>
</html>