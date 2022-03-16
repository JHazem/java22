<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

        <div id="container">
            <div>
               <a href="/dashboard"><h2>Dashboard</h2></a>
            </div>
            
            <h3>Name:  <c:out value="${lookify.name}"/></h3>
            <h3>Artist:  <c:out value="${lookify.artist}"/></h3>
            <h3>Rating (1-10):  <c:out value="${lookify.rating}"/></h3>
            <a href="/delete/<c:out value="${lookify.id}"/>"><h3>Delete</h3></a>
            
        </div>

</body>
</html>