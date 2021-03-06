package br.edu.ifpb.ads.psd.projeto.interfaces;

import br.edu.ifpb.ads.psd.projeto.entidades.Amizade;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AmizadeDaoIF {

    public void inserir(Amizade a)throws SQLException;
    
    public void remover(Amizade a)throws SQLException;
    
    public void atualizar(Amizade a)throws SQLException;
    
    public void aceita(Amizade amizade) throws SQLException;
    
    public boolean isAmigo(String emailUsuario, String emailAmigo) throws SQLException;
    
    public boolean isPendente(String emailUsuario, String emailAmigo) throws SQLException;
    
    public Amizade pesquisar(String emailUsuario, String emailAmigo)throws SQLException;
    
    public Amizade pesquisar(int id) throws SQLException;
    
    public ArrayList<Amizade> listar(String email) throws SQLException;    
    
    public ArrayList<String> listarSolicitacoes(String email) throws SQLException;
   
   
}