<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
 
	<div class="container">
        <div>
            <h1>New Category</h1>
            <form:form action="/categories/new" method="post" modelAttribute="addNewCategory">
                                
                <h2>
                    <form:label path="name"> Name:</form:label>
                    <form:input path="name"/>
                </h2>
           
                <input type="submit" value="Create Category333"/>         
            </form:form>
        </div>
        <div>
       		<form:errors path="addNewCategory"/>
        </div>
	</div>
</body>
</html>