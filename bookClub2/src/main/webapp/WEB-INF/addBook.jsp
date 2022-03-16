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

	<h1>Add a Book to Your Shelf!</h1>
	<a href="/logout">logout</a>
	<a href="/books">2222 Back to Shelves . . .</a>

	<div class="container">
		<form:form action="/books" modelAttribute="book" class="form" method="post">
			<form:hidden path="user" value= "${thisUser.id}"/>
			<div class="form-row">
				<form:label  path="title" for="title">Title:</form:label>
			 	<form:errors path="title" class="error"/>
				<form:input  path="title" type="text" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label  path="autherName"for="autherName">Author:</form:label>
				<form:errors path="autherName" class="error"/>
				<form:input  path="autherName" type="text" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label    path="thoughts" for="thoughts">Thoughts:</form:label>
				<form:errors   path="thoughts" class="error"/>
				<form:textarea path="thoughts" class="form-control"/>
			</div>
			
			
	
			<div>
				<input type="submit" value="submit" >
			</div>
			 </form:form>
	</div>



</div>
</body>
</html>