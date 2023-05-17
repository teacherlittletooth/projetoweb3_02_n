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
    
    
    //Listar os registros do BD
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
    
    
    //Excluir registros do BD
    public void deleteExame(int id) throws SQLException{
        String sql = "delete from exames where cod_exame = " + id;
        
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.execute();
        prep.close();
    }
    
    
    //Atualizar registros no BD
    public void updateExame(Exame ex) throws SQLException {
        //Query genérica
        String query = "UPDATE exames SET nome = ?, "
                   + "valor = ?, especialidade = ? "
                + "WHERE cod_exame = ?";
        
        //Preparando a query para ser executada no BD
        PreparedStatement prep = conn.prepareStatement(query);
        
        //Trocando as interrogações por seus respectivos valores
        prep.setString(1, ex.getTipo());
        prep.setDouble(2, ex.getValor());
        prep.setString(3, ex.getEspecialidade());
        prep.setInt(4, ex.getCodExame());
        
        //Executando a query pronta no BD
        prep.execute();
        prep.close();
    }
    
    
    //Selecionar um registro apenas
    public Exame listOneExame(int i) throws SQLException {
        //Query para selecionar apenas um registro
        String query = "SELECT * FROM exames "
                + "WHERE cod_exame = " + i ;
        
        //Preparando a query para executar no BD
        PreparedStatement prep = conn.prepareStatement(query);
        //Executando a query e lançando o resultado
        //no objeto result, da classe ResultSet
        ResultSet result = prep.executeQuery();
        
        //Criando um objeto vazio da classe Exame
        Exame ex = new Exame();
        //Caso obtenha algum registro do BD, o objeto "ex"
        //será preenchido com os respectivos valores
        if(result.next()){
            ex.setCodExame(result.getInt("cod_exame"));
            ex.setTipo(result.getString("nome"));
            ex.setValor(result.getDouble("valor"));
            ex.setEspecialidade(result.getString("especialidade"));
        }
        //Retornando o objeto da classe Exame
        return ex;
    }
    
}//Fim da classe
