<%-- 
    Document   : insert
    Created on : 17 Jul, 2019, 11:03:48 AM
    Author     : jerald
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("pass");
            Integer uid=1;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb","jerald", "12345678");
            Statement st=con.createStatement();
            
            st.executeUpdate("insert into register (uid,name,email,password)values('"+uid+"','"+name+"','"+email+"','"+password+"')");
             
            out.println("data inserted");
            }
            catch(Exception e){
                out.println(e);
            }
            %>
    </body>
</html>
