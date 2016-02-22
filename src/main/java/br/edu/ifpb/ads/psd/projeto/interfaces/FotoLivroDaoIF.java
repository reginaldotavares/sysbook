package br.edu.ifpb.ads.psd.projeto.interfaces;

import br.edu.ifpb.ads.psd.projeto.entidades.Foto;
import java.sql.SQLException;
import java.util.List;

public interface FotoLivroDaoIF {
    
    public void publicarFoto(Foto foto) throws SQLException;
    
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException;
}
