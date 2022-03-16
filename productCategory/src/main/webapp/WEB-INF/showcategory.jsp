    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/main.css">
<title><c:out value="${category.name}"/></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
   	<div class="container">
       <div> 
             <div>
         		  <h1> <c:out value="${category.name}"/></h1>
         		  
	             <h2>Products:</h2>
	             <ul>
	             <!-- To add products to the list in category we choice it-->
		             <c:forEach items="${myproducts}" var="product">
		                     <h3>-<c:out value="${product.name}"/></h3>
		             </c:forEach>
	             </ul>
      		</div>         
      		<!-- show the list of category and add aproduct to the list in left side -->      
  		 <form action="/categories/${category.id}" method="post">
      		<h2>
	          <label name="product">Add Product:</label>
	            <select name="product">
	                 <c:forEach items="${products}" var="product">
	                   <option value="${product.id}">
                 		  <c:out value="${product.name}"/>
	                   </option>
	                 </c:forEach>
	            </select>
			 </h2>
      	<%--  	<input type ="hidden" path="category" value="${category.id}" /> --%>
     		 <input type="submit" value="Add Product444"/>           
  		 </form>
	 	</div>
    </div>
</body>
</html>
   
    