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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous">
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

  <div class="container"></br>
  
  <h1> Welcome,  <c:out value="${user.name}"/></h1></br>
  
  <a href="/logout">logout</a></br></br>
  
		 <p>TV Shows</p>
		 
		  <!-- header table -->
     <table  class="table table-striped">
        <thead>
            <tr>
	               
	              <th>Show</th>
	              <th>Network</th>
	              <th>Average Rating</th>
            </tr>
        </thead>
     		 <!-- Body of table -->
    	<tbody>
            <c:forEach items="${tvshows}" var="tvshow">            
            <tr> 
             
                 <td> <a href="/tvshows/${tvshow.id}"><c:out value="${tvshow.show}"/></a></td>  
                <td><c:out value="${tvshow.netWork}"/></td>
                <td><c:out value="${tvshow.averageRating}"/></td>
             	 	 
             </tr>
             
            </c:forEach>
     
         </tbody>
      
     </table></br>
             <a href="/tvshows/new">1111 Add a Show</a>
  </div>
 
</body>
</html>












