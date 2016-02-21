package com.br.sistema.Gerenciadores;

import com.br.sistema.Entidades.Autores;
import com.br.sistema.Fabricas.DaoFactory;
import com.br.sistema.Fabricas.DaoFactoryIF;
import com.br.sistema.Interfaces.AutoresDaoIF;
import java.sql.SQLException;

public class GerenciadorDeAutores {
    
    public void adicionarAutores(String isbnLivro, String nome) throws SQLException{
        Autores novoAutor = new Autores();
        novoAutor.setIsbnLivro(isbnLivro);
        novoAutor.setNomeAutor(nome);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AutoresDaoIF autoresDao = fabrica.criaAutoresDao();
        autoresDao.inserir(novoAutor); 
    }
    
    public void removerAutores(Autores autor) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AutoresDaoIF autoresDao = fabrica.criaAutoresDao();
        autoresDao.remover(autor);
    }
    
    public void atualizaAutores(Autores autor) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AutoresDaoIF autoresDao = fabrica.criaAutoresDao();
        autoresDao.atualizar(autor);
    }
    
    public Autores pesquisarAutores(String nome) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AutoresDaoIF autoresDao = fabrica.criaAutoresDao();
        return autoresDao.pesquisar(nome);
    }
    
}
