<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
 <%@ page isErrorPage="true" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

  
<h1>Edit Language</h1>
   
  <a href="/languages/delete/<c:out value="${language.id}"/>">delete</a>
  <a href="/languages">Dashboard</a>
 
  <div>
  
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
	    <input type="hidden" name="_method" value="put">
	    <p>
	    
	        <form:label path="name">Name: </form:label>
	        <form:errors path="name" class="text-danger"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator:  </form:label>
	        <form:errors path="creator" class="text-danger"/>
	        <form:textarea path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version:  </form:label>
	        <form:errors path="version" class="text-danger"/>
	        <form:input path="version"/>
	    </p>
	 
	 	<input type="submit" value="submit">
		
	</form:form>

</div>
</body>
</html>