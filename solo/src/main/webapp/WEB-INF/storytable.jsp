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
</br>
  <div class="container" style = "position:relative; left:20px; top:2px;"> 
  	<div> 
  		 <a href="/home" style = "position:relative; left:10px; top:2px;" class="btn btn-primary">  Home </a> 
  		 <a href="/places" style = "position:relative; left:40px; top:2px;" class="btn btn-primary">  Place Table</a>  
		  <a href="/stories/new" style = "position:relative; left:70px; top:2px;" class="btn btn-primary">   Add Story </a> 
		  <a href="/logout" style = "position:relative; left:45%; top:2px;" class="btn btn-primary">   logout</a>    
	</div></br>
	
	<div><h3  style = "position:relative; left:35%; top:2px; color:red">Stories Table</h3></div></br>
	
	
	
		<!-- Search box -->
		
	 	 <div style = "position:relative; left:30%; top:2px;">
	         <form action="/user/story_search" method="post">
	        	<button>Search: </button>
	        	<input type="text" name="freeText" placeholder="Enter Title To Search">
	         </form>
          </div></br>
         
         
         
         
		  <!-- header table -->
	     <table class="table">
	        <thead>
	            <tr>
		               <th>Id</th>
		              <th>Title</th> 
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
 	                <td><c:out value="${story.content}"/></td> 
 	                <!-- choose c:choose when the other wise if session user id == story creater id other wise show the button-->
  	                 <c:choose>
  	                 	<c:when test="${story.user.id == user.id}">
  	                 		 <td> <a href="/stories/delete/<c:out value="${story.id}"/>" >Delete</a> 
	                   	   	  <a href="/stories/${story.id}/edit" style = "position:relative; left:30px; top:2px;"> Edit</a> 
	                		</td> 
  	                 	</c:when> 
  	               		  <c:otherwise></c:otherwise>
  	                 </c:choose>
  	                 
			            
	           	 </tr>
	             
	            </c:forEach>
	     
	         </tbody>
	      
	     </table>
  </div>  
</body>
</html>












