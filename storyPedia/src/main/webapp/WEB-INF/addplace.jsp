<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
</br> 
<div class="container">

	
	 <a href="/home" class="btn btn-primary">Home</a> 
	 <a href="/places" class="btn btn-primary">Back  </a> 
	 		  <a href="/stories/new" class="btn btn-primary">   Add Story </a> 
	 
	 <a href="/logout" style = "position:relative; left:50%; top:2px;" class="btn btn-primary">logout</a> 
	 
	<h3 style = "position:relative; left:350px; top:2px; color:red">Create a Place</h3>
	
	<div class="container">
		<form:form action="/places" modelAttribute="addNewPlace" class="form" method="post">
			<form:hidden path="user" value= "${thisUser.id}"/>
			
			<div class="form-row">
				<form:label  path="placeName" for="placeName">Place Name:</form:label>
			 	<form:errors path="placeName" class="error"/>
				<form:input  path="placeName" type="text" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label  path="city" for="city">City:</form:label>
			 	<form:errors path="city" class="error"/>
				<form:input  path="city" type="text" class="form-control"/>
			</div>
			 
			
			<div class="form-row">
				<form:label  path="content" for="content">Place Content:</form:label>
				<form:errors path="content" class="error"/>
				<form:input  path="content" type="text" class="form-control"/>
			</div></br>
			
			<!-- <div>
				  <label for="postedDate">posted Date:</label>
				  <input type="date" id="birthday" name="postedDate">
				  
				</div></br> -->
				 
			<div>
				 <a href="/places" class="btn btn-primary">Cancel</a>
				<input type="submit" value="submit" class="btn btn-primary">
			</div>
			 </form:form>
	</div> 
</div>




</body>
</html>



















