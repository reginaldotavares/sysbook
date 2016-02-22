package br.edu.ifpb.ads.psd.projeto.gerenciadores;


import br.edu.ifpb.ads.psd.projeto.entidades.Foto;
import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactory;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactoryIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.FotoLivroDaoIF;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class GerenciadorDeFotoLivro {
    
    public void publicarFoto(String url, Timestamp data, Usuario usuario) throws SQLException {
        Foto foto = new Foto();
        foto.setData(data);
        foto.setUrl(url);
        foto.setUsuario(usuario);
        DaoFactoryIF daoFactory =DaoFactory.creatFactory();
        FotoLivroDaoIF fotoLivroDao = daoFactory.criaFotoLivroDao();
        fotoLivroDao.publicarFoto(foto);
    }
    
    public List<Foto> listarFotos(Integer id_usuario) throws SQLException{
        DaoFactoryIF daoFactory =DaoFactory.creatFactory();
        FotoLivroDaoIF fotoLivroDao = daoFactory.criaFotoLivroDao();
        return fotoLivroDao.listarFotos(id_usuario);
    }
}