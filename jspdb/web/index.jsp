<%-- 
    Document   : index
    Created on : 17 Jul, 2019, 10:58:35 AM
    Author     : jerald
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert.jsp" method="post">
            <pre>
                <label> Name</label>
                <input type="text" name="name"><br>
                <label> Email</label>
                <input type="text" name="email"><br>
                <label> Password</label>
                <input type="password" name="pass"><br>
<input type="submit" name="submit" value="submit">
            </pre>
        </form>
    </body>
</html>
