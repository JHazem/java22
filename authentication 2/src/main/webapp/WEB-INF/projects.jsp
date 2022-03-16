<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome, <c:out value="${user.userName}"/></h3>
	<p>This your dashbord Nothing to see here yet.</p>
	<a href="/logout">Logout/</a>
	<!-- <input type="submit" value="Log out"/> -->
</body>
</html>