package com.br.sistema.Fabricas;



import com.br.sistema.DAO.AmizadeDao;
import com.br.sistema.DAO.AutoresDao;
import com.br.sistema.DAO.ComentarioDao;
import com.br.sistema.DAO.FotoDAO;
import com.br.sistema.DAO.FotoLivroDao;
import com.br.sistema.DAO.GrupoDao;
import com.br.sistema.DAO.LivroDao;
import com.br.sistema.DAO.TopicoDao;
import com.br.sistema.DAO.UsuarioDao;
import com.br.sistema.Interfaces.AmizadeDaoIF;
import com.br.sistema.Interfaces.AutoresDaoIF;
import com.br.sistema.Interfaces.ComentarioDaoIF;
import com.br.sistema.Interfaces.FotoDaoIF;
import com.br.sistema.Interfaces.FotoLivroDaoIF;
import com.br.sistema.Interfaces.GrupoDaoIF;
import com.br.sistema.Interfaces.LivroDaoIF;
import com.br.sistema.Interfaces.TopicoDaoIF;
import com.br.sistema.Interfaces.UsuarioDaoIF;

public class DaoFactoryBD implements DaoFactoryIF{
    
    private DaoFactoryBD instance;
    
    public AmizadeDaoIF criaAmizadeDao() {
        return new AmizadeDao();
    }

    public AutoresDaoIF criaAutoresDao() {
        return new AutoresDao();
    }
    @Override
    public ComentarioDaoIF criaComentarioDao() {
        return new ComentarioDao();
    }

    @Override
    public FotoDaoIF criaFotoDao() {
        return new FotoDAO();
    }
    
    public FotoLivroDaoIF criaFotoLivroDao() {
        return new FotoLivroDao();
    }
    
    public LivroDaoIF criaLivroDao() {
        return new LivroDao();
    }
    
    public GrupoDaoIF criaGrupoDao() {
        return new GrupoDao();
    }

    public TopicoDaoIF criaTopicoDao() {
        return new TopicoDao();
    }

    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }
    
    

}
