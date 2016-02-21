package com.br.sistema.Interfaces;

import com.br.sistema.Entidades.Foto;
import java.sql.SQLException;
import java.util.List;

public interface FotoLivroDaoIF {
    
    public void publicarFoto(Foto foto) throws SQLException;
    
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException;
}
