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
</head>
<body> 

	<form:form action="/comments/${story.id}" method="post" modelAttribute="commentObject">
		<p> 
			<form:label path="comment">Add your Comment: </form:label>
			<form:errors path="comment"/>
			<form:textarea path="comment"  class="fom-control" />
		    
		    <form:hidden path="story"   value= "${story.id}"/>
		    <form:hidden path="user"  value= "${user}"/> 
		</p>  
			<input type="submit" value="Comment" />
		    
	</form:form></br>
		 	
</body>
</html>