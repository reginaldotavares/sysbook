package com.br.sistema.DAO;





import com.br.sistema.Conexao.ClasseConexao;
import com.br.sistema.Conexao.ConnectionFactory;
import com.br.sistema.Entidades.Comentario;
import com.br.sistema.Interfaces.ComentarioDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDao implements ComentarioDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public ComentarioDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    @Override
    public List<Comentario> comentarioTopico(int idTopico) throws SQLException {
        try {
            conexao.abrir();
            String sql = "SELECT * FROM Comentario WHERE id_topico=? ORDER BY data DESC";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setInt(1, idTopico);
            ResultSet rs = stat.executeQuery();
            List<Comentario> lista = new ArrayList<>();
            while (rs.next()) {
               Comentario comentario = new Comentario();
               comentario.setId(rs.getInt("id"));
               comentario.setTexto(rs.getString("texto"));
               UsuarioDao usuario=new UsuarioDao();
               comentario.setUsuario(usuario.getUsuario(rs.getString("usuario")));
               lista.add(comentario);
            }
            if(lista.size()>0){
                return lista;
            }
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }

    @Override
    public void criarComentario(String texto, Timestamp data, int idTopico, int idUsuario) throws SQLException {
      try{
          conexao.abrir();
          String sql="INSERT INTO comentario(texto,data,id_topico,usuario) VALUES (?,?,?,?)";
          PreparedStatement stat=con.prepareStatement(sql);
          stat.setString(1, texto);
          stat.setTimestamp(2, data);
          stat.setInt(3, idTopico);
          stat.setInt(4, idUsuario);
          stat.executeUpdate();
      } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }
    
  
}