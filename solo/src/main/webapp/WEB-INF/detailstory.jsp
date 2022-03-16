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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
</br> 
<div class="container">

		<div class="container"></br>
  		  <a href="/home" class="btn btn-primary"> Home </a>  
		 <a href="/stories" class="btn btn-primary">Back </a></br></br> 
			<h3>Story Detail</h3>
			  	<hr style="width:50%;text-align:left;margin-left:0"></br>
			
		   	<h3> Title: <c:out value="${story.title}"/> </h3> 
		   	  	<hr style="width:50%;text-align:left;margin-left:0"></br>
		   	
		   	<h3>Comment: ${story.content} </h3> </br></br>
	 
		
			 
			
			 <a href="/stories/delete/<c:out value="${story.id}"/>" class="btn btn-primary">Delete</a> 
			 <a href="/stories/${story.id}/edit" class="btn btn-primary"> edit</a> 
		 </div>
	</div> 
	
</body>
</html>