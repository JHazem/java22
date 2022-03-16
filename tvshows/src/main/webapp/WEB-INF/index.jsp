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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous">
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

<div class="container"> 
<h1> Tv Shows</h1> 


			<!-- Register form -->
	
		<div class="row"> 
			<div class="col"> 
				<h1>Register</h1>
				     		  	<!-- match11 -->			 			<!-- match1 -->
				<form:form action="/registration" method="post" modelAttribute="user">
					<div class="form-group">
										<!-- match2 -->	
						<form:label path ="name">Name:</form:label><br/>
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
					</div></br>
					
						<input type="submit" value="Register"/>
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
					
				</div></br>
				
				<input type="submit" value="Login"/>
			</form>
			</div>
		</div>	
	</div>	

</body>
</html>