package br.edu.ifpb.ads.psd.projeto.gerenciadores;

import br.edu.ifpb.ads.psd.projeto.entidades.Autores;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactory;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactoryIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.AutoresDaoIF;
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
