<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

        <Div id="container">
                <div>
                   <h2>Songs by artist: <c:out value="${artist}"/></h2>
                   <div>
                       <form action="/search" method="post">
                          <input type="search" name="artist" placeholder="Artist">
                          <input type="submit" value="New Search">
                       </form>
                       <a href="/dashboard"><h2>Dashboard</h2></a>
                   </div>
                </div>
                <table>
                    <thead>
                      <tr>
                         <th>Name</th>
                         <th>Rating</th>
                         <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lookifies}" var="lookify">
                        <tr>
                           <td><a href="lookifies/<c:out value="${lookify.id}"/>"><c:out value="${lookify.name}"/></a></td>
                           <td><c:out value="${lookify.rating}"/></td>
                           <td><a href="/delete/<c:out value="${lookify.id}"/>">Delete</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </Div>

</body>
</html>