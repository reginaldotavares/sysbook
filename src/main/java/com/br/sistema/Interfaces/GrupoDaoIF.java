package com.br.sistema.Interfaces;


import com.br.sistema.Entidades.Grupo;
import com.br.sistema.Entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface GrupoDaoIF {
    
    public void inserir(Grupo g, Usuario u)throws SQLException;
    
    public void remover(Grupo g)throws SQLException;
    
    public void atualizar(Grupo g)throws SQLException;
    
    public Grupo pesquisar(String nome)throws SQLException;
    
    public List<Grupo> pesquisarGrupos(String nome) throws SQLException;
}
