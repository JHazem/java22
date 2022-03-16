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

	<button><a href="/projects">3333 Back to Dashboard  </a></button>
		<div class="container">
			<h3>Project Detail</h3>
			   <h3> Project: <c:out value="${project.title}"/> </h3>
			   
			   <h3>Description: ${project.description} </h3>
			    
         </div>
         
	     <div class="form-row">
			<h3><c:out value="${project.dueDate}"/></h3>
		 </div></br></br>
			
  	 	  <div >
			<button style="background-color:Red;" >
			
			 <a href="/projects/delete/<c:out value="${project.id}"/>">Delete</a>  </button>
			 <button><a href="/projects/${project.id}/edit"> edit</a></button>
		 </div>
	</div> 
	
</body>
</html>