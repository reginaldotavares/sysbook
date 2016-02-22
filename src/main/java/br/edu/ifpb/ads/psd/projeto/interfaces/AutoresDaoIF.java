package br.edu.ifpb.ads.psd.projeto.interfaces;


import br.edu.ifpb.ads.psd.projeto.entidades.Autores;
import java.sql.SQLException;


public interface AutoresDaoIF {

    public void inserir(Autores a)throws SQLException;
    
    public void remover(Autores a)throws SQLException;
    
    public void atualizar(Autores a)throws SQLException;
    
    public Autores pesquisar(String nome)throws SQLException;
    
}
