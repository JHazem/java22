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
		 <a href="/logout"  style = "position:relative; left:70%; top:2px;" class="btn btn-primary">    logout</a>   </br></br>
		
 <h1 style = "position:relative; left:135px; top:2px;"> Welcome,  <c:out value="${user.name}" /> with StoryPidia from life</h1></br>
 <%--    <video width="300" controls style = "position:relative; left:22%; top:2px;">
   <source src="camel.mp4" type = "video/mp4"> </video></br></br>
   --%>
   	
  <h3 style = "position:relative; left:33%; top:2px;">What are you looking for ?</h3>
		
			<hr style="width:50%;text-align:left;margin-left:0; position:relative; left:23%; top:2px;""></br>
		

	 	
	 	
	     	 <a href="/places"  style = "position:relative; left:35%; top:2px;" class="btn btn-primary"> Place </a> 
	     		 <a href="/stories"  style = "position:relative; left:40%; top:2px;" class="btn btn-primary">  Story  </a> 
	     
  </div>  

</body>
</html>












