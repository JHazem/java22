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
<h1> Book Club</h1>
<p>A place for friends to share thoughts on books.</p>
	
<!-- 	<form action="/processFormData" method="post"> -->

			<!-- Register form -->
	
		<div class="row"> 
			<div class="col"> 
				<h1>Register</h1>
				     		  	<!-- match11 -->			 			<!-- match1 -->
				<form:form action="/registration" method="post" modelAttribute="user">
					<div class="form-group">
										<!-- match2 -->	
						<form:label path ="name">User Name:</form:label><br/>
						<form:errors path ="name" class="text-danger"/>
						<form:input path="name"/>
					</div>
					
					<div class="form-group">
					
						<form:label path ="email">Email:</form:label><br/>
						<form:errors path ="email" class="text-danger"/>
						<form:input path="email"/>
					</div>
					
					<div class="form-group">
					
						<form:label path ="password">Password:</form:label><br/>
						<form:errors path ="password" class="text-danger"/>
						<form:input path="password" type="password"/>
					</div>
					<div class="form-group">
				
						<form:label path ="passCodeConfirm">Confirm PW:</form:label><br/>
						<form:errors path ="passCodeConfirm" class="text-danger"/>
						<form:input path="passCodeConfirm" type="password"/>
					</div>
					
						<input type="submit" value="submit"/>
				</form:form>
			</div>
			
	
			<!-- Log in form -->
		
	<div class="col">		
		<h1>Login</h1>
			<form method="post" action="/login">
				<p class="text-dnger"></p>
				<div class="form-group">
					<c:out value="${error}"/> <!-- To valid login -->
				
				
					<label type ="email" for="email">Email:</label><br/>
					<input type ="text" name="email" class="form-control" id="email"/>
				</div>
				
				<div class="form-group">
					<label for="password">Password:</label><br/>
					<input type="password"  name="password"  class="form-control" id="password"/>
					
				</div>
				
				<input type="submit" value="submit"/>
			</form>
			</div>
		</div>	
	</div>	
 
</body>
</html>