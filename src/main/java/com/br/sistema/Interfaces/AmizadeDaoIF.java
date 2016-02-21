package com.br.sistema.Interfaces;

import com.br.sistema.Entidades.Amizade;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AmizadeDaoIF {

    public void inserir(Amizade a)throws SQLException;
    
    public void remover(Amizade a)throws SQLException;
    
    public void atualizar(Amizade a)throws SQLException;
    
    public Amizade pesquisar (String email)throws SQLException;
    
    public ArrayList<Amizade> listar(String email)throws SQLException;
   
}