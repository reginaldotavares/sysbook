package br.edu.ifpb.ads.psd.projeto.gerenciadores;

import br.edu.ifpb.ads.psd.projeto.entidades.Amizade;
import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactory;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactoryIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.AmizadeDaoIF;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class GerenciadorDeAmizade {
    
    public void enviarConviteAmizade(Usuario usuario, Usuario amigo) throws SQLException, ParseException{
        Amizade novaAmizade = new Amizade();
        novaAmizade.setEmailUsuario(usuario.getEmail());
        novaAmizade.setEmailAmigo(amigo.getEmail());
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        amizadeDao.inserir(novaAmizade); 
    }
    
    public void removerAmizade(Amizade a) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        amizadeDao.remover(a);
    }
    
    public void recusaAmizade(Amizade a) throws SQLException{
        removerAmizade(a);
    }
    
    public void aceitaAmizade(Amizade a) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        amizadeDao.aceita(a);
    }
    
    public Amizade pesquisarAmizade(String emailUsuario, String emailAmigo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        return amizadeDao.pesquisar(emailUsuario, emailAmigo);
    }
    
    public boolean isAmigo(String emailUsuario, String emailAmigo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        return amizadeDao.isAmigo(emailUsuario, emailAmigo);
    }
    
    public boolean isPendente(String emailUsuario, String emailAmigo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        return amizadeDao.isPendente(emailUsuario, emailAmigo);
    }
    public ArrayList<Amizade> listarAmizade(String emailUsuario) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        AmizadeDaoIF amizadeDao = fabrica.criaAmizadeDao();
        return amizadeDao.listar(emailUsuario);
    }
    
    public ArrayList<String> listarSolicitações(String emailUsuario) throws SQLException{
        return DaoFactory.creatFactory().criaAmizadeDao().listarSolicitacoes(emailUsuario);
    }
}
