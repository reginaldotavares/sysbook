package com.br.sistema.Gerenciadores;


import com.br.sistema.Entidades.Foto;
import com.br.sistema.Entidades.Usuario;
import com.br.sistema.Fabricas.DaoFactory;
import com.br.sistema.Fabricas.DaoFactoryIF;
import com.br.sistema.Interfaces.FotoLivroDaoIF;
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