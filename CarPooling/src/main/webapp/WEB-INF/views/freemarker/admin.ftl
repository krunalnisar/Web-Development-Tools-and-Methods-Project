
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/header.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link href="resources/css/table.css" rel="stylesheet">
</head>
<body>

<div class="row" >
			<div class="col-md-5">
			</div>
			
			<div class="col-md-3">
			<h1>CARPOOL  WEBSITE</h1>
			</div>	
			
			<div class="col-md-2">
			</div>
			<div class="col-md-1">
			<h2>${user.name}</h2>
			</div>
			<div class="col-md-1" class="logout">
			<h2><a href="logout.html">Logout</a></h2>
			</div>
	</div>

<nav>
  <div class="bookend"></div>
  <ul>
   <!--  <li><a href="#"><i class="icon-user"></i></a></li> -->
    <li><a href="mytrips.html"><i class="icon-home"></i> My Trips</a></li>
    <li><a href="searcharide.html"><i class="icon-search"></i> Search Trip</a></li>
    <li><a href="postATrip.html"><i class="icon-tag"></i> Post Trip</a></li>
    <li><a href="messages.html"><i class="icon-envelope"></i> Messages</a></li>
    <li></li>
  </ul>
  <div class="bookend"></div>
</nav>
<div id="space"></div>

<form action="userstatus.html">
<table border ="1">
        <tr>
            <th>User Id</th>
            <th>Username</th>
            <th>Status</th>
             <th>Delete</th>
        </tr>
        
        <#list userList as user>
		<tr>
	      	<th>${user.userId }</th>
            <th>${user.name }</th>
         
         			<#if user.status == true>
            		<td>Active</td>
            		</#if>
            		
            		<#if user.status == false>
            		<td>Blocked</td>
            		</#if>
          
            <#if user.status == true>
            <th><input type="checkbox" name="delete" value="${user.userId}"/> Block</th>
            </#if>
            
            <#if user.status == false>
            <th><input type="checkbox" name="delete" value="${user.userId}"/> Active</th>
            </#if>
            
     	</tr>  
		</#list>
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