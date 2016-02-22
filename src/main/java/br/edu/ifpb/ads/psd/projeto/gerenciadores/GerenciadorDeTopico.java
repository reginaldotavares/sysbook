package br.edu.ifpb.ads.psd.projeto.gerenciadores;

import br.edu.ifpb.ads.psd.projeto.entidades.Topico;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactory;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactoryIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.TopicoDaoIF;
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
