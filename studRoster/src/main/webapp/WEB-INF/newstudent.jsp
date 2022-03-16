    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>New Student</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
        <div class="container">
             <div>
                <h1>New Student</h1> 	     
	             
		          <form:form action="/students/create" method="post" modelAttribute="newStudent">                  
		              <h2>
		                  <form:label path="firstName">First Name:</form:label>
		                  <form:input path="firstName"/>
		              </h2>
		              <h2>
		                  <form:label path="lastName">Last Name:</form:label>
		                  <form:input path="lastName"/>
		              </h2>
		              <input type="submit" value="Create"/>         
		          </form:form>
	 		</div> 
				 	
        </div>
</body>
</html>