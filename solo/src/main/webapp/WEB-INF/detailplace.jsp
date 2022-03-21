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
  		  <a href="/home" class="btn btn-primary"> Home </a> 
		 <a href="/places"  class="btn btn-primary">Back </a> 
			 <a href="/logout"  style = "position:relative; left:70%; top:2px;" class="btn btn-primary">    logout</a> </br>

 
		<div class="container"></br>
			<h3  style = "position:relative; left:40%; top:2px;color:red">${place.placeName} Stories</h3></br>
			  <%--  <h3> Place: <c:out value="${place.placeName}"/> </h3> --%>
			   
			  
			    
         </div>
         
	    <%--  <div class="form-row">
			<h3><c:out value="${place.postedDate}"/></h3>
		 </div></br></br>
			 --%>
			 
			     <table class="table">
	        <thead>
	            <tr>
		               <th>Id</th>
		              <th>Story Title</th>
		             
		          
		              <th>Content</th> 
		              <th>Actions</th>
	            </tr>
	        </thead>
	        
	     						 	 <!-- Body of table -->
	    	<tbody>
	    	
	            <c:forEach items="${stories}" var="story">  
	                     <!-- To fill information inside the table -->
	            
	            <tr>  
	               	 <td><c:out value="${story.id}"/></td>
  	                 <td> <a href="/stories/${story.id}"><c:out value="${story.title}"/></a></td> 
  	                 
  	                 <td>  ${story.content} </td>
  	                   
  	          <!-- 
  					 <td>
  	                     <c:choose>
	  	                 	<c:when test="${story.user.id == user.id}">
	  	                 		 <td> <a href="/stories/delete/<c:out value="${story.id}"/>" >Delete</a> 
		                   	   	  <a href="/stories/${story.id}/edit" style = "position:relative; left:30px; top:2px;"> Edit</a> 
		                		</td> 
	  	                 	</c:when> 
  	               		  <c:otherwise></c:otherwise>
  	                	 </c:choose> 
        			 </td>
	    	  -->
	            </tr>
	            </c:forEach>
	     
	         </tbody>
 	      
	     </table>
			  
  
	</div> 
 
</body>
</html>