package br.edu.ifpb.ads.psd.projeto.interfaces;

import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDaoIF {
    
    public void inserir(Usuario u)throws SQLException;
    
    public void remover(String email)throws SQLException;
    
    public void atualizar(Usuario u)throws SQLException;
    
    public Usuario pesquisar(String nome)throws SQLException;
    
    public boolean verificarExistenciaEmail(String email) throws SQLException;
    
    public boolean logar(String nome, String senha)throws SQLException;
    
    public List<Usuario> Listar() throws SQLException;
    
    public void atualizarImagemPerfil(String path, int idUsuario)throws SQLException;
    
    public Usuario getUsuario(String email) throws SQLException;
    
    public Usuario getUsuario(Integer id) throws SQLException;
}
