<%-- 
    Document   : home
    Created on : 27 de abr. de 2023, 19:30:33
    Author     : QI
--%>
<%@include file="session/verify.jsp" %>
<%@page import="model.User"%>
<%
    User userSession =  (User) session.getAttribute("userNewSession");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exames</title>
    </head>
    <body>
        <p>
        Bem vindo <%=
                                (userSession != null)
                                        ? userSession.getUserName() 
                                        : "visitante"
                          %>
        <button onclick="window.location.href='session/logout.jsp'">Logout</button>
        </p>
        <hr>
        <button onclick="window.location.href='cadastro.jsp'">
            CADASTRAR
        </button>
        <button onclick="window.location.href='lista.jsp'">
            LISTAR
        </button>
    </body>
</html>
