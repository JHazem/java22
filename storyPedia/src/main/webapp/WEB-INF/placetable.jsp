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
  <div class="container" >  
  
		<div> 
		
		 <a href="/home" style = "position:relative; left:30px; top:2px;" class="btn btn-primary"> Home </a>  
		 <a href="/stories" class="btn btn-primary" style = "position:relative; left:50px; top:2px;"> Stories Table</a> 
		 <a href="/places/new" style = "position:relative; left:70px; top:2px;" class="btn btn-primary">   Add place </a> 
		 <a href="/logout"  style = "position:relative; left:45%; top:2px;" class="btn btn-primary">          logout</a>  
	</div></br> 
	
	
										<!-- Search box -->
	
	 	 <div><h3  style = "position:relative; left:35%; top:2px; color:red">Places Table</h3></div></br> 

         
         
          <div style = "position:relative; left:30%; top:2px;">
	         <form action="/user/place_search" method="post">
	        	<button>Search: </button>
	        	<input type="text" name="freeText" placeholder="Enter Place To Search">
	         </form>
          </div></br>
            
									  <!-- header table -->
	     <table class="table">
	        <thead>
	            <tr>
		               <th>Id</th>
		              <th>Place Name</th>
		              <th>City</th>
		          
		              <th>Content</th> 
		              <th>Actions</th>
	            </tr>
	        </thead>
	        
	     						 	 <!-- Body of table -->
	    	<tbody>
	    	
	            <c:forEach items="${places}" var="place">  
	                     <!-- To fill information inside the table -->
	            
	            <tr>  
	                <td><c:out value="${place.id}"/></td>
  	                 <td> <a href="/places/${place.id}"><c:out value="${place.placeName}"/></a></td> 
  	                <%-- <td> <a href="/stories/${place.placeName}"><c:out value="${place.placeName}"/></a></td> --%> 
  	                <td>  ${place.city} </td> 
  	             
  	                <td>  ${place.content} </td>  
	                 
	                 <%-- <td>
 		                 <a href="/places/delete/<c:out value="${place.id}"/>">Delete</a> 
	             	    <a href="/places/${place.id}/edit" style = "position:relative; left:20px; top:2px;"> edit</a> 
	             	     <a href="https://www.google.com/maps/place/${place.placeName}" style = "position:relative; left:30px; top:2px;">Visit City</a> 
   	                </td>  --%> 
			            
			            <c:choose>
  	                 	<c:when test="${place.user.id == user.id}">
  	                 		 <td> <a href="/places/delete/<c:out value="${place.id}"/>" >Delete</a>  
	                   	   	  <a href="/places/${place.id}/edit" style = "position:relative; left:30px; top:2px;"> Edit</a> </td>
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












