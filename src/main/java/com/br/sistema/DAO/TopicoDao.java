package com.br.sistema.DAO;

import com.br.sistema.Conexao.ClasseConexao;
import com.br.sistema.Conexao.ConnectionFactory;
import com.br.sistema.Entidades.Topico;
import com.br.sistema.Interfaces.TopicoDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TopicoDao implements TopicoDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public TopicoDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void inserir(Topico topico) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "INSERT INTO Topico(titulo, texto, data, usuario, id_grupo) VALUES (?,?,?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, topico.getTitulo());
            pstm.setString(2, topico.getTexto());
            pstm.setTimestamp(3, topico.getData());
            pstm.setString(4, topico.getUsuario().getEmail());
            pstm.setInt(5, topico.getGrupo().getId());
            pstm.executeUpdate();

            pstm.executeUpdate();

        } finally {
            conexao.liberar();
        }
    }

    public void remover(Topico topico) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "delete from topico where titulo=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, topico.getTitulo());

            pstm.executeUpdate();
        } finally {
            conexao.liberar();
        }
    }

    public void atualizar(Topico topico) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "update Topico set titulo=?, conteudo=? where id=?";
            
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, topico.getTitulo());
            pstm.setString(2, topico.getTexto());
            pstm.setTimestamp(3, topico.getData());
            pstm.setString(4, topico.getUsuario().getEmail());
            pstm.setInt(5, topico.getGrupo().getId());

            pstm.executeUpdate();
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }

    public Topico pesquisar(String titulo) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "select * from topico where titulo ilike '%"+ titulo +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
            
            Topico topico = new Topico();
            
            while(result.next()){
                topico.setId(result.getInt("id"));
                topico.setTitulo(result.getString("titulo"));
                topico.setTexto(result.getString("texto"));
            }
            return topico;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public Topico getTopico(Integer id) throws SQLException {
        try {
            conexao.abrir();
            String sql = "SELECT * FROM topico WHERE id=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            
            Topico topico = new Topico();
            if (result.next()) {
                topico.setTitulo(result.getString("titulo"));
                topico.setTexto(result.getString("texto"));
                topico.setData(result.getTimestamp("apelido"));
                UsuarioDao usuario=new UsuarioDao();
                topico.setUsuario(usuario.getUsuario(result.getString("usuario")));
               
            }
                return topico;
              } catch(Exception E) { 
                    E.printStackTrace();
               } finally {
            conexao.liberar();
        }
        return null;    
    }
}