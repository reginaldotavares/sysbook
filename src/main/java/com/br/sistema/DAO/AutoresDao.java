package com.br.sistema.DAO;




import com.br.sistema.Conexao.ClasseConexao;
import com.br.sistema.Conexao.ConnectionFactory;
import com.br.sistema.Entidades.Autores;
import com.br.sistema.Interfaces.AutoresDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AutoresDao implements AutoresDaoIF{
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public AutoresDao(){
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void inserir(Autores autor) throws SQLException {
        
        try {
            conexao.abrir();
            
            String SQL = "insert into autores(isbnLivro, nome) values (?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, autor.getIsbnLivro());
            pstm.setString(2, autor.getNomeAutor());
            

            pstm.executeUpdate();

        } finally {
            conexao.liberar();
        }
    }

    public void remover(Autores autor) throws SQLException{
        try {
            conexao.abrir();
            
            String SQL = "delete from autores where nome=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, autor.getNomeAutor());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } finally {
            conexao.liberar();
        }
    }

    public void atualizar(Autores autor) throws SQLException{
        
        try {
            conexao.abrir();
            
            String SQL = "update autores set nome=? where isbnLivro=?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, autor.getNomeAutor());
            pstm.setString(2, autor.getIsbnLivro());
           
          
            pstm.executeUpdate();
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }

    public Autores pesquisar(String nome) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "select * from autores where nome ilike '%"+ nome +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
            
            Autores autor = new Autores();
            
            while(result.next()){
                autor.setIsbnLivro(result.getString("isbnLivro"));
                autor.setNomeAutor(result.getString("nome"));
                
            }
            return autor;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
