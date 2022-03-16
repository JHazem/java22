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
		  
	
		   <h3> <c:out value="${tvshow.show}"/> </h3>
		   <button><a href="/tvshows">3333 Back to Dashboard  </a></button>
			<button><a href="/logout">logout</a></button></br>
	
		   <hr style="width:50%;text-align:left;margin-left:0">
		   
		   		<h3>Posted by: ${tvshow.user.name} </h3>
		   
		   	<hr style="width:50%;text-align:left;margin-left:0">
		   
		   		<h3>Network: ${tvshow.netWork} </h3>
		    
		   <hr style="width:50%;text-align:left;margin-left:0">
				
	  	 		 <h3>Description: <c:out value="${tvshow.description}"/></h3>
	  	 		
  		 	<hr style="width:50%;text-align:left;margin-left:0"></br>
  		 	 
				<button><a href="/tvshows/${tvshow.id}/edit"> edit</a></button>  
			
			</div>
			 
	</div></br></br>
 
  
 
 	<!-- Rating body -->
 
 	<div class="container">
		<h3>Rating Table..</h3>
		
			<table class="table">
			<thead>
				<tr>
				 
					<th>Name</th>
					<th>Rating</th> 
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="tvshow" items="${mytvshows}">			
					<tr>
						 <%-- <td><c:out value="${tvshow.id}"/></td>
							<td>
								<a href="/tvshows/${tvshow.id}">
									<c:out value="${tvshow.title}"/>
								</a>
							</td>   
						  --%>
							<td>33 ${tvshow.user.name}</td>
							<td> 22 ${tvshow.averageRating}</td>
						<td>
							<a href="/tvshows/return/${tvshow.id}"> return </a>
				       </td>
					</tr>
					
		<%-- <form>
	            <input type="radio" name="rating" value="1" class="star">
	            <input type="radio" name="rating" value="2" class="star">
	            <input type="radio" name="rating" value="3" class="star">
	            <input type="radio" name="rating" value="4" class="star">
	            <input type="radio" name="rating" value="5" class="star">
	        </form>
	 	--%>
	 
				</c:forEach> 
			</tbody>			
			</table>
		</div>
	
 
 
</body>
</html>