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


<div class="container">

	<button><a href="/projects">3333 Back to Dashboard  </a></button>
		<div class="container">
			<h3>Project  : <c:out value="${project.title}"/> </h3>
			<h3>Project  Lead: <c:out value="${project.firstName}"/> </h3>
				   <div class="form-row">
					   	<h3>Add a task ticket for this team: </h3>
		         
						<label    name="task" for="task"> </label> 
						<textarea name="task" class="form-control"></textarea>
				  </div>
         
				<input type="submit" value="submit" >
			</div>
			
			
			 <form action="/projects/${project.id}" method="post">
      		<h2>
	          <label name="user">
		          <h3> 
						 Add by<c:out value="${user.name}"/> at <c:out value="${project.dueDate}"/>:
			 	  </h3>
			</label>
	             
	                 <c:forEach items="${users}" var="user">
		                   
		                   		<c:out value="${user.name}"/>
		                   		<c:out value="${project.description}"/>
		                 
	                 </c:forEach>
	          
			 </h2>
      	 	<%-- <input type="hidden" path="project" value="${project.id}" /> --%>
     		 <input type="submit" value="Add Product222"/>           
  		 </form>
			
			 
			
</div>
</head>
<body>

</body>
</html>