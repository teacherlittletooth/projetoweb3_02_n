package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    }//Fim do insert
    
    public ArrayList<Exame> listExame() throws SQLException{
       ArrayList<Exame> list = new ArrayList<>();
       
       String sql = "select * from exames"; 
       
       PreparedStatement prep = conn.prepareStatement(sql);
       ResultSet result =  prep.executeQuery();
       
       while(result.next()){
           Exame e = new Exame();
           
           e.setCodExame(result.getInt("cod_exame"));
           e.setTipo(result.getString("nome"));
           e.setValor(result.getDouble("valor"));
           e.setEspecialidade(result.getString("especialidade"));
           
           list.add(e);
       }
       
       return list;
    }//Fim do método list
    
    public void deleteExame(int id) throws SQLException{
        String sql = "delete from exames where cod_exame = " + id;
        
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.execute();
        prep.close();
    }
    
    
}//Fim da classe
