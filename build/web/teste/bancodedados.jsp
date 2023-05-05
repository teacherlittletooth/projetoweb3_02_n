<%@page import="java.sql.SQLException"%>
<%@page import="model.MyConnection"%>
<%
    out.print("Teste de conexão com Banco de Dados:<hr>");
    try {
        MyConnection.getConnection();
        out.print("Conexão bem sucedida!<br>");
        out.print("Nome do Banco de dados: " + MyConnection.getConnection().getCatalog());
    } catch(SQLException e) {
        out.print("Erro de conexão<hr>" + e);
    }
%>