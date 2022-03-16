<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

  <div class="container">
  
  <h1> Welcome,  <c:out value="${user.firstName}"/></h1>
  
  
		<button><a href="/projects/new">   1111 Add Project to my shelf</a></button>
		<button><a href="/logout">          logout</a>    </button>
		
		  <!-- header table -->
	     <table class="table">
	        <thead>
	            <tr>
		               
		              <th>Project</th>
		              <th>Team Lead</th>
		              <th>Due Date</th>
		              <th>Actions</th>
	            </tr>
	        </thead>
	     		 <!-- Body of table -->
	    	<tbody>
	    	
	            <c:forEach items="${notMyProjects}" var="project">  
	                     <!-- To fill information inside the tavle -->
	            
	            <tr>  
	                 
	               <%--  <td> <a href="/projects/${project.title}"></a></td>  --%> <!-- title Link -->
	               <td> <a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
	                <td><c:out value="${project.user.firstName}"/></td>
	                <td><c:out value="${project.dueDate}"/></td>
	                 
	                <td>
		                 <a href="/projects/join/${project.id}"> Join team  </a> 
		                 <a href="/projects/delete/<c:out value="${project.id}"/>">Delete</a> 
	                </td>
			            
	           	 </tr>
	             
	            </c:forEach>
	     
	         </tbody>
	      
	     </table>
  </div> 
 					<!-- Join Project body --> 
 					
	<div class="container">
		<h3>Your Projects</h3>
		
		<table class="table">
		<thead>
			<tr>
				 <th>Project</th>
	              <th>Lead</th>
	              <th>Due Date</th>
	              <th>Actions</th>
			</tr>
		</thead>
					
		<tbody>
			<c:forEach var="project" items="${myProjects}">			
				<tr> 
					<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a> </td>  
					<td><c:out value="${project.user.firstName}"/></td>
					<td><c:out value="${project.dueDate}"/></td>
					<%-- <td> <a href="/projects/return/${project.id}">Leave team</a></td> --%>
					
					<td>  
					<c:choose>
					 	<c:when test="${project.user.id ==  user.id}">
				 		   <a href="/projects/${project.id}/edit">   edit  </a> 
			           	  
					 	</c:when>
					 <c:otherwise>
					 <a href="/projects/return/${project.id}">Leave team</a>
					 </c:otherwise>
					 </c:choose>
				
				</td>
				
				
				
				
				
				
				</tr>
				
				
				
				
				
				
			</c:forEach> 
		</tbody>			
		</table>
	</div> 
</body>
</html>












