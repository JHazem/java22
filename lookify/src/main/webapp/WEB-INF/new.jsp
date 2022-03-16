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
</head>
<body>



<div>
	<div> <a href="/dashboard"><h2>Dashboard</h2></a></div>

	<form:form action="/process" method="post" modelAttribute="addNew">

	<h3>
		<form:label path="name">Name:</form:label>
		<form:input path="name"/>
		<form:errors path="name"/>
	</h3>

	<h3>
		<form:label path="artist">Artist:</form:label>
		<form:input path="artist"/>
		<form:errors path="artist"/>
	</h3>
	
	<h3>
		<form:label path="rating">Rating:</form:label>
			<form:select cssClass="box" path="rating">
				<form:option value="1">1</form:option>
				<form:option value="2">2</form:option>
				<form:option value="3">3</form:option>

			</form:select>
		<form:errors path="rating"/>
	</h3>
	
		<input type="submit" value="Add Song"/>
	</form:form>
	
	

</div>
</body>
</html>