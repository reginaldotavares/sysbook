package com.br.sistema.Interfaces;


import com.br.sistema.Entidades.Comentario;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface ComentarioDaoIF {
        
    public List<Comentario> comentarioTopico(int idTopico) throws SQLException;
    
    public void criarComentario(String texto,Timestamp data,int idTopico,int idUsuario) throws SQLException;
            
}
