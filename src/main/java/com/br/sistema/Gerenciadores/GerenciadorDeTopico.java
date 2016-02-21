package com.br.sistema.Gerenciadores;

import com.br.sistema.Entidades.Topico;
import com.br.sistema.Fabricas.DaoFactory;
import com.br.sistema.Fabricas.DaoFactoryIF;
import com.br.sistema.Interfaces.TopicoDaoIF;
import java.sql.SQLException;

public class GerenciadorDeTopico {
    
    public void adicionarTopico(String titulo, String texto) throws SQLException{
        Topico novoTop = new Topico();
        novoTop.setTitulo(titulo);
        novoTop.setTexto(texto);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        TopicoDaoIF topDao = fabrica.criaTopicoDao();
        topDao.inserir(novoTop);
    }
    
    public void removerTopico(Topico topico) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        TopicoDaoIF topDao = fabrica.criaTopicoDao();
        topDao.remover(topico);
    }
    
    public void atualizaTopico(Topico topico) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        TopicoDaoIF topDao = fabrica.criaTopicoDao();
        topDao.atualizar(topico);
    }
    
    public Topico pesquisarTopico(String titulo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        TopicoDaoIF topDao = fabrica.criaTopicoDao();
        return topDao.pesquisar(titulo);
    }
}
