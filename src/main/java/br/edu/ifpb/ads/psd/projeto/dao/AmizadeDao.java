package br.edu.ifpb.ads.psd.projeto.dao;


import br.edu.ifpb.ads.psd.projeto.conexao.ClasseConexao;
import br.edu.ifpb.ads.psd.projeto.conexao.ConnectionFactory;
import br.edu.ifpb.ads.psd.projeto.entidades.Amizade;
import br.edu.ifpb.ads.psd.projeto.interfaces.AmizadeDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AmizadeDao implements AmizadeDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public AmizadeDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void inserir(Amizade amizade) throws SQLException {
        
        try {
            conexao.abrir();
            
            String SQL = "insert into Amizade(emailUsuario, emailAmigo) values (?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, amizade.getEmailUsuario());
            pstm.setString(2, amizade.getEmailAmigo());

            pstm.executeUpdate();

        } finally {
            conexao.liberar();
        }
    }

    public void remover(Amizade amizade) throws SQLException{
        try {
            conexao.abrir();
            
            String SQL = "delete from Amizade where emailAmigo=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, amizade.getEmailAmigo());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } finally {
            conexao.liberar();
        }
    }

    public void atualizar(Amizade amizade) throws SQLException{
        
        try {
            conexao.abrir();
            
            String SQL = "update Amizade set emailUsuario=?, emailAmigo=? where id=?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, amizade.getEmailUsuario());
            pstm.setString(2, amizade.getEmailAmigo());
            pstm.setInt(3, amizade.getId());

            pstm.executeUpdate();
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }
    
    public Amizade pesquisar(String email) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "select * from Amizade where email = ?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, email);
            
            ResultSet result = pstm.executeQuery();
            
            Amizade amizade = new Amizade();
            
            while(result.next()){
                amizade.setEmailUsuario(result.getString("emailUsuario"));
                amizade.setEmailAmigo(result.getString("emailAmigo"));
                amizade.setId(result.getInt("id"));
            }
            return amizade;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public ArrayList<Amizade> listar(String email) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "select * from Amizade where emailUsuario = ?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, email);
            
            ResultSet result = pstm.executeQuery();
            
            ArrayList<Amizade> listaIdAmizades = new ArrayList<Amizade>();
            
            while(result.next()){
                Amizade amizade = new Amizade();
                
                amizade.setEmailUsuario(result.getString("emailUsuario"));
                amizade.setEmailAmigo(result.getString("emailAmigo"));
                amizade.setId(result.getInt("id"));
                
                listaIdAmizades.add(amizade);
            }
            return listaIdAmizades;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
