<%-- 
    Document   : cadastrar
    Created on : 4 de mai. de 2023, 19:55:09
    Author     : QI
--%>
<%@include file="session/verify.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro</h1>
        <hr>
        <form action="ExameController" method="post">
            <h2>Novo Exame</h2>
            <input type="text" name="exame" placeholder="Digite o nome do exame" required>
            <br><br>
            <input type="number" name="valor" placeholder="Digite o valor do exame" min="0" step="0.01" required >
            <br><br>
            <select name="especialidade" required>
                <option value="">Selecione a especialidade</option>
                <option value="Gastro">Gastro</option>
                <option value="Dentista">Dentista</option>
                <option value="Neuro">Neuro</option>
                <option value="Pediatra">Pediatra</option>
            </select>
            <br><br>
            <input type="submit" value="Cadastrar">
        </form>
        <hr>
        <a href="home.jsp">Página inicial</a>
    </body>
</html>
