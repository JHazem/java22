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

<div class="container">

	<button><a href="/books">3333 Back to Shelves  </a></button>

	<div class="container">
	
		   <h3> <c:out value="${book.title}"/> </h3>
		   
		   <h3>${book.user.name} read  ${book.title}  by ${book.autherName} </h3>
		   
           <h3>Here are ${book.user.name}'s thoughts</h3>
           
           
			<hr style="width:50%;text-align:left;margin-left:0">
				
	  	 				<h3><c:out value="${book.thoughts}"/></h3>
	  	 		
  		 	<hr style="width:50%;text-align:left;margin-left:0">
  		 	
			
				<button><a href="/books/${book.id}/edit"> edit</a></button>  <!-- Link refer to edit page -->
			</div>
			 
	</div>



</body>
</html>