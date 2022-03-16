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

<h1>New language</h1>

<form:form action="/languages/new" method="post" modelAttribute="language">
	<div>
		<form:label path ="name"> Name</form:label>
		<form:errors path ="name" class="text-danger"/>
		<form:input path="name"/>
	</div>
	
	<div>
		<form:label path ="creator">Creator</form:label>
		<form:errors path ="creator" class="text-danger"/>
		<form:input path="creator"/>
	</div>
	
	<div>
		<form:label path ="version">Version</form:label>
		<form:errors path ="version" class="text-danger"/>
		<form:input path="version"/>
	</div>
	
	
	<input type="submit" value="send"/>
</form:form>

</body>
</html>