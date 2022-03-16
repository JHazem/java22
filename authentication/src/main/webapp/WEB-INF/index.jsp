<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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


<h1 color="blue"> Welcome!</h1>
	
<!-- 	<form action="/processFormData" method="post"> -->

			<!-- Register -->
	<div class="container"> 
		<div class="row"> 
			<div class'"col"> 
				<h1>Register</h1>
				     		  	<!-- match11 -->			 			<!-- match1 -->
				<form:form action="/register" method="post" modelAttribute="user">
					<div class="form-group">
										<!-- match2 -->	
						<form:label path ="userName">User Name:</form:label><br/>
						<form:errors path ="userName" class="text-danger"/>
						<form:input path="userName"/>
					</div>
					
					<div class="form-group">
					
						<form:label path ="email">Email:</form:label><br/>
						<form:errors path ="email" class="text-danger"/>
						<form:input path="email"/>
					</div>
					
					<div class="form-group">
					
						<form:label path ="password">Password:</form:label><br/>
						<form:errors path ="password" class="text-danger"/>
						<form:input path="password"/>
					</div>
					<div class="form-group">
				
						<form:label path ="passwordConfirm">Confirm PW:</form:label><br/>
						<form:errors path ="passwordConfirm" class="text-danger"/>
						<form:input path="passwordConfirm"/>
					</div>
					
						<input type="submit" value="Register"/>
				</form:form>
			</div>
			
			<!-- Log in -->
			
	<div class="col">		
		<h1>Login</h1>
			<form method="post" action="login">
				<p class="text-dnger">
				</p>
				
				<c:out value="${error}"/> <!-- To valid login -->
				<div class="form-group">
					<label type="email" for="email">Email:</label><br/>
					<input class="form-control" type="text" id="email" name="email"/>
				</div>
				
				<div class="form-group">
					<label for="password">Password:</label><br/>
					<input  class="form-control" type="password" id="password" name="password"/>
					
				</div>
				
				<input type="submit" value="Login"/>
			</form>
		</div>	
		
</body>
</html>