package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExameDAO {
    private static Connection conn;
    
    public ExameDAO() throws ClassNotFoundException, SQLException {
        conn = MyConnection.getConnection();
    }
    
    //Métodos CRUD para a tabela "exames" do BD
    public void insertExame(Exame ex) {
        //Query genérica
        String sql = "INSERT INTO exames(nome, valor, especialidade)"
                        + "VALUES (?, ?, ?)";
        
        //Objeto que preparará a query para enviar ao BD
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, ex.getTipo());
            prep.setDouble(2, ex.getValor());
            prep.setString(3, ex.getEspecialidade());
            
            prep.execute();
            prep.close();
            
        } catch(SQLException erro) {
            System.out.println("Erro no insert :(");
        }
    }
}
