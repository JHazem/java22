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
		 <a href="/logout"  style = "position:relative; left:85%; top:2px;" class="btn btn-primary">    logout</a>   </br>
		
 		<h1 style = "position:relative; left:22%; top:2px; color:Green"> Welcome,  <span style="color:#FF0000 "><b><c:out value="${user.name}"/></b></span> with StoryPedia</h1></br>
       
 	 	<h3 style = "position:relative; left:20%; top:2px;">Are you looking for a story in a specific Place or Title ?</h3>
			<p style = "position:relative; left:25%; top:2px;"> Share your story and fun memories in a particular city or town with others,</p>
			<p style = "position:relative; left:23%; top:2px;"> or add  comments to other people's stories your and let your imagination run wild. </p>
		
		
		<hr style="width:50%;text-align:left;margin-left:0; position:relative; left:23%; top:2px;"></br>
		 
     	 <a href="/places"  style = "position:relative; left:34%; top:2px;" class="btn btn-primary"> Places Table</a> 
   		 <a href="/stories"  style = "position:relative; left:40%; top:2px;" class="btn btn-primary">  Stories Table</a> </br></br>
	     
	     <a href="/places/new" style = "position:relative; left:23%; top:2px;" class="btn btn-primary">   Add place </a>
	     <a href="/stories/new" style = "position:relative; left:55%; top:2px;" class="btn btn-primary">   Add Story </a>
	     
  </div>  <br>
	     <video width="500" height= "300" controls style = "position:relative; left:27%; top:2px;">
   		<source src="camel.mp4" type = "video/mp4"> </video> </br></br>
   		
 		<!-- <img src="/imges/indian.jpg" alt="indian"/> --> 
</body>
</html> 		
 		