<%-- 
    Document   : lista
    Created on : 4 de mai. de 2023, 19:56:33
    Author     : QI
--%>

<%@page import="model.ExameDAO"%>
<%@page import="model.Exame"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exames</title>
    </head>
    <body>
        <h1>Lista</h1>
        <table>
            <thead>
                <th>CODIGO</th>
                <th>NOME</th>
                <th>VALOR</th>
                <th>ESPECIALIDADE</th>
                <th></th>
                <th></th>
            </thead>
            <tbody>
            <%
                      ExameDAO e = new ExameDAO();
                      for(Exame item : e.listExame()){
                %>
                <tr>
                    <td><%= item.getCodExame() %></td>
                    <td><%= item.getTipo() %></td>
                    <td><%= item.getValor() %></td>
                    <td><%= item.getEspecialidade() %></td>
                    <td>
                        <a href="#editar<%= item.getCodExame() %>">🖊</a>
                    </td>
                    <td>
                        <a href="#apagar<%= item.getCodExame() %>">🗑</a>
                    </td>
                </tr>
            <%
                    }
                %>
            </tbody>
        </table>
        <hr>
        <a href="home.jsp">Página inicial</a>
    </body>
</html>
