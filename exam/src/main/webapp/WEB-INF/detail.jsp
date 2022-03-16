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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous">
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">

	<div class="container">
		   
	
		   <h3> <c:out value="${bundler.babyName}"/> </h3>
		   <p>(added by  <c:out value="${bundler.user.name}"/>)</p>
			

	
		   <hr style="width:50%;text-align:left;margin-left:0">
		   
		   		<%-- <h3>New Name: ${bundler.user.babyName} </h3> --%>
		   		<h3>New Name: ${bundler.babyName} </h3>
		   
		   	<hr style="width:50%;text-align:left;margin-left:0">
		   
		   		<h3>Typical Gender: ${bundler.gender} </h3>
		   		
		   	<hr style="width:50%;text-align:left;margin-left:0">
		   
		   		<h3>Origin: ${bundler.gender} </h3>
		    
		   <hr style="width:50%;text-align:left;margin-left:0">
				
	  	 		 <h3>Meaning: <c:out value="${bundler.meaning}"/></h3>
	  	 		
  		 	<hr style="width:50%;text-align:left;margin-left:0"></br>
  		 	 
				<button><a href="/bundlers/${bundler.id}/edit"> edit</a></button>  
			
			</div>
			 
	</div></br></br>
 
 
</body>
</html>