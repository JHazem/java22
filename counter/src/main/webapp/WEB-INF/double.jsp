<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

	<h1>You have to visited 
		<a href=" http://localhost:8080"> times</a>
	</h1>
	<c:out value="${count}"/>
	<a href="/" class="test">Test another visit?</a>
	<a href ="/reset"><button>Reset Count</button></a>
</body>
</html>