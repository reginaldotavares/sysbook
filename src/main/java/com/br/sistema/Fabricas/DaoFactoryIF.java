package com.br.sistema.Fabricas;

import com.br.sistema.Interfaces.AmizadeDaoIF;
import com.br.sistema.Interfaces.AutoresDaoIF;
import com.br.sistema.Interfaces.ComentarioDaoIF;
import com.br.sistema.Interfaces.FotoDaoIF;
import com.br.sistema.Interfaces.FotoLivroDaoIF;
import com.br.sistema.Interfaces.GrupoDaoIF;
import com.br.sistema.Interfaces.LivroDaoIF;
import com.br.sistema.Interfaces.TopicoDaoIF;
import com.br.sistema.Interfaces.UsuarioDaoIF;



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
