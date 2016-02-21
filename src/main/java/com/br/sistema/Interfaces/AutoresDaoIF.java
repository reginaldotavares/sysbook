package com.br.sistema.Interfaces;


import com.br.sistema.Entidades.Autores;
import java.sql.SQLException;


public interface AutoresDaoIF {

    public void inserir(Autores a)throws SQLException;
    
    public void remover(Autores a)throws SQLException;
    
    public void atualizar(Autores a)throws SQLException;
    
    public Autores pesquisar(String nome)throws SQLException;
    
}
