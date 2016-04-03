package br.edu.ifpb.ads.psd.projeto.gerenciadores;

import br.edu.ifpb.ads.psd.projeto.converterInformacao.ConverterData;
import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactory;
import br.edu.ifpb.ads.psd.projeto.fabricas.DaoFactoryIF;
import br.edu.ifpb.ads.psd.projeto.interfaces.UsuarioDaoIF;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class GerenciadorDeUsuario {
    
    public void adicionarUsuario(String email, String nome, String apelido, String senha, String cidade, String estado, String fotoCapa, Date dataNascimento) throws SQLException{
        Usuario novoUsuario = new Usuario();
        ConverterData data = new ConverterData();
        novoUsuario.setEmail(email);
        novoUsuario.setNome(nome);
        novoUsuario.setApelido(apelido);
        novoUsuario.setSenha(senha);
        novoUsuario.setCidade(cidade);
        novoUsuario.setEstado(estado);
        novoUsuario.setDataNascimento(dataNascimento);
        novoUsuario.setFoto(fotoCapa);
        
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.inserir(novoUsuario); 
    }
    
    public void removerUsuario(String email) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.remover(email);
    }
    
    public void atualizaUsuario(Usuario u) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.atualizar(u);
    }
    
    public List<Usuario> pesquisarUsuario(String nome) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisar(nome);
    }
    
    public Usuario getUsuario(int id) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
        return usuario.getUsuario(id);
    }

    public Usuario getUsuario(String email) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
        return usuario.getUsuario(email);
    }
    
    public void atualizarFotoPerfil(String caminho, int id) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
        usuario.atualizarImagemPerfil(caminho, id);
    }
    
    public boolean logar(String email, String senha) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.logar(email, senha);
    }
    
    public List<Usuario> listarUsuarios() throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.Listar();
    }
    
    public Usuario pesquisarUsuarioEmail(String email) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.getUsuario(email);
    }
    
    public boolean verificarExistenciaEmail(String email) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuario = fabrica.criaUsuarioDao();
        return usuario.verificarExistenciaEmail(email);
    }
    
}
