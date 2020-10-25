<%-- 
    Document   : shoppingList
    Created on : Oct 24, 2020, 3:33:27 PM
    Author     : 751682
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
       
    </head>
    <body>
        <h1>Shopping List</h1>
              
        <h3>
            Hello, ${username} <a href="ShoppingList?action=logout">Logout</a>
     
        </h3>
        <h2>List </h2>
        
        <form method="post" action="?action=add">
        
            Add item: <input type="text" name="item">
            <input type="submit" value="Add">
                    
        </form>
        <form method ="post" action="?action=delete">
            <c:if test="${!empty list}">
                <c:forEach items="${list}" var="item">                   
                  <input type="radio" name="deleteitem" value="${item}">${item}
                    <br>
                </c:forEach>

                <input type="submit" value="Delete">
            </c:if>
                  
        </form>
    </body>
</html>
