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
     <a href="/home" class="btn btn-primary"> Home </a> 
	
	 <a href="/stories" class="btn btn-primary">Back </a> </br></br>
	<h1 style = "position:relative; left:350px; top:2px;"> Edit ${story.title}  </h1> 

	<div class="container">
	<form:form action="/stories/${story.id}" modelAttribute="story" class="form" method="post">
			<form:hidden path="user" value="${story.user.id}"/>
			 
			
			<div class="form-row">
				<form:label  path="title" for="title">Title:</form:label>
			 	<form:errors path="title" class="error"/>
				<form:input  path="title" type="text" class="form-control"/>
			</div>
 
			
			<div class="form-row">
				<form:label  path="content" for="content"> Content:</form:label>
				<form:errors path="content" class="error"/>
				<form:input  path="content" type="textbox" class="form-control"/>
			</div></br>
			
				<div>
				  <label for="posted">Due Date:</label>
				  <input type="date" id="birthday" name="posted" >
				  
				</div>	</br>
				  <div>
				<input type="submit" value="submit" class="btn btn-primary">
			</div>  
			 </form:form>
	</div> 
</div>


</body>
</html>