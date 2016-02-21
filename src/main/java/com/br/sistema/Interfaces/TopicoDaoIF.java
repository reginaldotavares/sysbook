package com.br.sistema.Interfaces;


import com.br.sistema.Entidades.Topico;
import java.sql.SQLException;

public interface TopicoDaoIF {
    
    public void inserir(Topico t)throws SQLException;
    
    public void remover(Topico t)throws SQLException;
    
    public void atualizar(Topico t)throws SQLException;
    
    public Topico pesquisar(String topico)throws SQLException;
    
}
