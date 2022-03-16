<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous">
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>

  <div class="container"></br>
 	  
	  <h1> Hello,  <c:out value="${currentUser.name}"/>    </h1> 
	  <a href="/logout">logout</a></br></br>
	  
 	  
		 <h3>All Song Labs</h3>
		 
		  <!-- header table -->
     <table  class="table table-striped">
        <thead>
            <tr>
	               
	              <th>Song</th>
	             
	              <th># of Collaborations</th> 
            </tr>
        </thead>
     		 <!-- Body of table -->
    	<tbody>
            <c:forEach items="${songs}" var="song"> 
                       
            <tr>  
            
      
                 <td> <a href="/songs/${song.id}"><c:out value="${song.songTitle}"/></a></br>   
                 <c:out value="${song.genre}"/></td>

              <td><c:out value="${song.coll}"/></td> 
             </tr>
             
            </c:forEach>
      
         </tbody>
      
     </table></br>
             <button><a href="/songs/new">New Song</a></button>
  </div>
 
</body>
</html>
 










