package com.br.sistema.Gerenciadores;

import com.br.sistema.Entidades.Livro;
import com.br.sistema.Fabricas.DaoFactory;
import com.br.sistema.Fabricas.DaoFactoryIF;
import com.br.sistema.Interfaces.LivroDaoIF;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorDeLivros {
    
    public void adicionarLivros(String isbn, String titulo, Integer anoPublicacao, String editora, String fotoCapa, String tema) throws SQLException{
        Livro novoLivro = new Livro();
        
        novoLivro.setIsbn(isbn);
        novoLivro.setTitulo(titulo);
        novoLivro.setAnoPublicacao(anoPublicacao);
        novoLivro.setEditora(editora);
        novoLivro.setFotoCapa(fotoCapa);
        novoLivro.setTema(tema);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        LivroDaoIF livroDao = fabrica.criaLivroDao();
        livroDao.inserir(novoLivro);
    }
    
    public void removerLivro(Livro livro) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        LivroDaoIF livroDao = fabrica.criaLivroDao();
        livroDao.remover(livro);
    }
    
    public void atualizaLivro(Livro livro) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        LivroDaoIF livroDao = fabrica.criaLivroDao();
        livroDao.atualizar(livro);
    }
    
    public Livro pesquisarLivro(String titulo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        LivroDaoIF livroDao = fabrica.criaLivroDao();
        return livroDao.pesquisar(titulo);
    }
    
    public List<Livro> listarLivros() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        LivroDaoIF livroDao = fabrica.criaLivroDao();
        return livroDao.listar();
    }
    
    public List<Livro> listarPesquisaLivros(String titulo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        LivroDaoIF livroDao = fabrica.criaLivroDao();
        return livroDao.ListarpesquisaLivro(titulo);
    }
    
}