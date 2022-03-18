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

		<div class="container"></br>
  		  <a href="/home" class="btn btn-primary"> Home </a>  
		 <a href="/stories" class="btn btn-primary">Back </a> 
		 <a href="/logout"  style = "position:relative; left:60%; top:2px;" class="btn btn-primary">logout</a></br>
			<h3  style = "position:relative; left:40%; top:2px;">Story Detail</h3>
			  	<hr style="width:50%;text-align:left;margin-left:0"> 
			
		   	<h3> Title: <c:out value="${story.title}"/> </h3> 
		   	  	<hr style="width:50%;text-align:left;margin-left:0"> 
		   	
		   	<h3>Content: ${story.content} </h3> </br> 
	   

									<!-- if user create a story can be edit or delete -->
			   <c:choose>
  	                 	<c:when test="${story.user.id == user}">
  	                 		 <td> <a href="/stories/delete/<c:out value="${story.id}" />" class="btn btn-primary">Delete</a> 
	                   	   	  <a href="/stories/${story.id}/edit"  class="btn btn-primary"> Edit</a> 
	                		</td> 
  	                 	</c:when> 
 	               		  <c:otherwise></c:otherwise>
              	 </c:choose>  	</br> 	
              	 
              	  
				 	 				<!-- add comment -->
		 	<div > 
				<form:form action="/mystories/${story.id}" method="post" modelAttribute="commentObject">
					<p>
						<form:label path="comment">Add your Comment: </form:label>
						<form:textarea path="comment" type="text" />
						<form:errors path="comment" />
					   <%-- <input type="hidden" name="story" value="${mystory.id}">  --%>
					   
					   <!-- two hidden button one for session id and other for story id -->
					   <form:hidden path="story"   value= "${story.id}"/>
					   <form:hidden path="user"  value= "${user}"/>
					     
					      
					</p>  
						<input type="submit" value="Comment" />
					   
  	                     
        		 
				</form:form>
		 	
		 	<hr />
				  	 <!-- To see all comments -->
              	 
              	 <c:forEach items="${story.comments}" var="comment"> 
              	 	<p>${comment.comment}</p>
              	 
              	 </c:forEach>
              	 
		  </div> 
	 </div>	
</body>
</html>