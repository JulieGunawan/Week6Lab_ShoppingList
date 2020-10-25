<%-- 
    Document   : register
    Created on : Oct 24, 2020, 3:33:40 PM
    Author     : 751682
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <form action="?action=register" method="post">
              Username:
              <input type="text" name="username">
            <button type ="submit" name="action" value="register">Register name</button>
        </form>
    </body>
</html>
