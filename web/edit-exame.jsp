<%-- 
    Document   : edit-exame
    Created on : 16 de mai. de 2023, 21:38:35
    Author     : QI
--%>

<%@page import="model.Exame" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Exame e = (Exame)request.getAttribute("exame");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edição</h1>
        <hr>
        <form action="ExameController" method="post">
            <input type="text" name="cod" value="<%= e.getCodExame() %>" readonly>
            <br><br>
            
            <input type="text" name="exame" value="<%= e.getTipo()%>" placeholder="Digite o nome do exame" required>
            <br><br>
            
            <input type="number" name="valor" value="<%= e.getValor()%>" placeholder="Digite o valor do exame" min="0" step="0.01" required >
            <br><br>
            <select name="especialidade" required>
                <option value="<%= e.getEspecialidade()%>"><%= e.getEspecialidade()%></option>
                <option value="Gastro">Gastro</option>
                <option value="Dentista">Dentista</option>
                <option value="Neuro">Neuro</option>
                <option value="Pediatra">Pediatra</option>
            </select>
            <br><br>
            <input type="submit" value="Atualizar">
        </form>
        <hr>
        <a href="home.jsp">Página inicial</a>
    </body>
</html>
