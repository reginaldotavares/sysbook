/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.psd.projeto.interfaces;



import br.edu.ifpb.ads.psd.projeto.entidades.Foto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Emanuel
 */
public interface FotoDaoIF {
    
    public void publicarFoto(Foto foto) throws SQLException;
    
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException;
    
}
