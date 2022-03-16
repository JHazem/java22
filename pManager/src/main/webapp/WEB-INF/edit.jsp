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

<div class="container">
	<h1>Edit Project</h1> 
	
	<button><a href="/projects">4444 Back to Shelves . . .</a></button>

	<div class="container">
	<form:form action="/projects/${project.id}" modelAttribute="project" class="form" method="post">
			<form:hidden path="user"  name="_method" value="${project.user.id}"/>
			
			<%-- <form:hidden value="${project.user.id}" path="user"/> --%>
			<%-- <c:out value="${error}"/> --%>
			
			<div class="form-row">
				<form:label  path="title" for="title">Title:</form:label>
			 	<form:errors path="title" class="error"/>
				<form:input  path="title" type="text" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label  path="description" for="description">Project Description:</form:label>
				<form:errors path="description" class="error"/>
				<form:input  path="description" type="text" class="form-control"/>
			</div>
			

				<div>
				  <label for="dueDate">Due Date:</label>
				  <input type="date" id="birthday" name="dueDate">
				  
				</div>	
				<div>
				<input type="submit" value="submit" >
			</div>
			 </form:form>
	</div>

</div>
</body>
</html>