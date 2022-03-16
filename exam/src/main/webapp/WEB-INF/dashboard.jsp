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
 	  
	  <h1> Hello,  <c:out value="${currentUser.name}"/>, here are some name suggestions..  </h1> 
	  <a href="/logout">logout</a></br></br>
	  
 	  
		 <h3>Baby Names</h3>
		 
		  <!-- header table -->
     <table  class="table table-striped">
        <thead>
            <tr>
	               
	              <th>Vote</th>
	              <th>Name</th>
	              <th>Typical Gender</th>
	              <th>Origin</th>
	              <th>UpVotes</th>
            </tr>
        </thead>
     		 <!-- Body of table -->
    	<tbody>
            <c:forEach items="${bundlers}" var="bundler">            
            <tr>  
            
           	 <!-- For Like & UnLike -->
	             	<c:choose>
	             		<c:when test="${bundler.voters.contains(currentUser)}">
	             		
		             		<td><a href="/unvote/${bundler.id}">UnVote</a></td>
	             		</c:when>
	             		<c:otherwise>
	             				<td><a href="/vote/${bundler.id}">Vote</a></td> 
	             		</c:otherwise> 
	             	</c:choose>
               <!--  /For Like & UnLike-->
              
                 <td> <a href="/bundlers/${bundler.id}"><c:out value="${bundler.babyName}"/></a></td>   
                <td><c:out value="${bundler.gender}"/></td>
                <td><c:out value="${bundler.origin}"/></td>
               	<td><c:out value="${bundler.voters.size()}"/></td> 
             </tr>
             
            </c:forEach>
     
         </tbody>
      
     </table></br>
             <a href="/bundlers/new">New Name</a>
  </div>
 
</body>
</html>
 










