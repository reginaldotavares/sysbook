package br.edu.ifpb.ads.psd.projeto.fabricas;

import br.edu.ifpb.ads.psd.projeto.interfaces.AmizadeDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.AutoresDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.ComentarioDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.FotoDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.FotoLivroDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.GrupoDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.LivroDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.TopicoDaoIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.UsuarioDaoIF;



public interface DaoFactoryIF {
    
    public AmizadeDaoIF criaAmizadeDao();
    
    public AutoresDaoIF criaAutoresDao();
    
    public ComentarioDaoIF criaComentarioDao();
    
    public FotoDaoIF criaFotoDao();
    
    public FotoLivroDaoIF criaFotoLivroDao();
    
    public GrupoDaoIF criaGrupoDao();
    
    public LivroDaoIF criaLivroDao();
    
    public TopicoDaoIF criaTopicoDao();
    
    public UsuarioDaoIF criaUsuarioDao();
}
