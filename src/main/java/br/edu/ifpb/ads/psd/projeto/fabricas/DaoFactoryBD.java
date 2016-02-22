package br.edu.ifpb.ads.psd.projeto.fabricas;



import br.edu.ifpb.ads.psd.projeto.dao.AmizadeDao;
import br.edu.ifpb.ads.psd.projeto.dao.AutoresDao;
import br.edu.ifpb.ads.psd.projeto.dao.ComentarioDao;
import br.edu.ifpb.ads.psd.projeto.dao.FotoDAO;
import br.edu.ifpb.ads.psd.projeto.dao.FotoLivroDao;
import br.edu.ifpb.ads.psd.projeto.dao.GrupoDao;
import br.edu.ifpb.ads.psd.projeto.dao.LivroDao;
import br.edu.ifpb.ads.psd.projeto.dao.TopicoDao;
import br.edu.ifpb.ads.psd.projeto.dao.UsuarioDao;
import br.edu.ifpb.ads.psd.projeto.interfaces.AmizadeDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.AutoresDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.ComentarioDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.FotoDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.FotoLivroDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.GrupoDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.LivroDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.TopicoDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.UsuarioDaoIF;

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
