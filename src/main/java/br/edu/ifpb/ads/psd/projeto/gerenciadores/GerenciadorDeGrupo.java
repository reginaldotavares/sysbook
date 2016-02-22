package br.edu.ifpb.ads.psd.projeto.gerenciadores;

import br.edu.ifpb.ads.psd.projeto.entidades.Grupo;
import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactory;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactoryIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.GrupoDaoIF;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorDeGrupo {
    
    public void adicionarGrupo(Usuario usuario, String nome, String descricao) throws SQLException{
        Grupo novoGrupo = new Grupo();
        novoGrupo.setEmailUsuario(usuario.getEmail());
        novoGrupo.setNome(nome);
        novoGrupo.setDescricao(descricao);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        gruDao.inserir(novoGrupo, usuario);
    }
    
    public void removerGrupo(Grupo grupo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        gruDao.remover(grupo);
    }
    
    public void atualizaGrupo(Grupo grupo) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        gruDao.atualizar(grupo);
    }
    
    public Grupo pesquisarGrupo(String nome) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        return gruDao.pesquisar(nome);
    }
    
    public List<Grupo> pesquisarGrupos(String nome) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        GrupoDaoIF gruDao = fabrica.criaGrupoDao();
        return gruDao.pesquisarGrupos(nome);
    }
}
