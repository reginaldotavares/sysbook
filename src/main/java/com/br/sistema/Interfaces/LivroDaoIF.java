package com.br.sistema.Interfaces;


import com.br.sistema.Entidades.Livro;
import java.sql.SQLException;
import java.util.List;

public interface LivroDaoIF {
    public void inserir(Livro l)throws SQLException;
    
    public void remover(Livro l)throws SQLException;
    
    public void atualizar(Livro l)throws SQLException;
    
    public Livro pesquisar(String titulo)throws SQLException;
    
    public List<Livro> listar() throws SQLException;
    
    public List<Livro> ListarpesquisaLivro(String titulo) throws SQLException;
   
}