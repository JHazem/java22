<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
   
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

		<div  class="container">
		
            <div>
	            <a href="/lookiies/new"><p>Add New</p></a>
	            <a href="/search/topten"><p>Top Songs</p></a>
            
	            <form action="/search" method="post">
                   <input type="submit" value="Search Artists">
                   <input type="search" name="artist" placeholder="Artist">
	            </form>
            </div>
            
			<table>
			<tbody>
				<thead>
					<tr>
						<th>Name</th>
						<th>Rating</th>
						<th>Action</th>
					</tr>
				</thead>
			
				<c:forEach var="lookify" items="${lookifies}">			
					<tr>
						<td><a href="/lookifies/<c:out value="${lookify.id}"/>"><c:out value="${lookify.name}"/></a></td>
						<td><c:out value="${lookify.rating}"/></td>

						<!-- delete -->				
						<td>
							<a href="/lookifies/delete/<c:out value="${lookify.id}"/>">Delete</a>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>			
			</table>
		</div>				
						
 <!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
						
</body>
</html>