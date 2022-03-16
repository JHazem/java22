<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 <link rel="stylesheet" href="/webjars/bootetrap/css/bootstrap.min.css">
 <link rel="stylesheet" href="/webjars/bootetrap/css/bootstrap.min.css">
</head>
<body>
	<div>
		<a href="/languages"><h3>Dashboard</h3></a>
	</div>
	
	<div>
		<h1><c:out value="${language.name}"/></h1>
		<p><c:out value="${language.creator}"/> </p>
		<p><c:out value="${language.version}"/> </p>
		
		<a href="/languages/edit/<c:out value="${language.id}"/>"> edit </a>
		<a href="/languages/delete/<c:out value="${language.id}"/>"> delete </a>
	</div>

 <script src="webjars/jquery/jquery.min.js"></script>
 <script src="webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>






