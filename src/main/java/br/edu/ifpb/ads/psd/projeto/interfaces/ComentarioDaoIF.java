package br.edu.ifpb.ads.psd.projeto.interfaces;


import br.edu.ifpb.ads.psd.projeto.entidades.Comentario;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface ComentarioDaoIF {
        
    public List<Comentario> comentarioTopico(int idTopico) throws SQLException;
    
    public void criarComentario(String texto,Timestamp data,int idTopico,int idUsuario) throws SQLException;
            
}
