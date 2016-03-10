<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/table.css" rel="stylesheet">
</head>
<body>

<%@include file = "header.jsp" %>
<div id="space"></div>

<form action="userstatus.html">
<table border ="1">
        <tr>
            <th>User Id</th>
            <th>Username</th>
            <th>Status</th>
             <th>Delete</th>
        </tr>
        
        
		<c:forEach var="user" items="${userList}">
		<tr>
	      	<th>${user.userId }</th>
            <th>${user.name }</th>
         
            		<c:if test="${user.status == true}">
            		<td>Active</td>
            		</c:if>
            		
            		<c:if test="${user.status == false}">
            		<td>Blocked</td>
            		</c:if>
          
            <c:if test="${user.status == true}">
            <th><input type="checkbox" name="delete" value="${user.userId}"> Block</th>
            </c:if>
            <c:if test="${user.status == false}">
            <th><input type="checkbox" name="delete" value="${user.userId}"> Active</th>
            </c:if>
     	</tr>  
		</c:forEach>
	 <tr>
     			<td colspan="7"> you have "${size}" Users"</td>
    </tr>
    <tr>
     			<td colspan="7"><input type="submit" name="submit" value="Change User Status"/></td>
    </tr>
</table>
</form>
</body>
</html>