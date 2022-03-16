    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title><c:out value="${product.name}"/></title>
</head>
<body>
   	<div class="container">
       <div>
             <div > <h1> <c:out value="${product.name}"/></h1>
               	<ul>
             <!-- To add categories to the list in product we choice it-->
	             
	             <h2>Categories:</h2>
	             
	             <c:forEach items="${mycategories}" var="category">
	                     <h3>-<c:out value="${category.name}"/></h3>
	             </c:forEach>
      		</div> 
              </ul>         
  		 <form action="/products/${product.id}" method="post">
      		<h2>
	          <label name="category"> Add Category:</label>
	            <select  name="category">
	                 <c:forEach items="${categories}" var="category">
		                   <option value="${category.id}">
		                   		<c:out value="${category.name}"/>
		                   </option>
	                 </c:forEach>
	            </select>
			 </h2>
      	 	<%-- <input type="hidden" path="product" value="${product.id}" /> --%>
     		 <input type="submit" value="Add Product222"/>           
  		 </form>
	 	</div>
    </div>
</body>
</html>