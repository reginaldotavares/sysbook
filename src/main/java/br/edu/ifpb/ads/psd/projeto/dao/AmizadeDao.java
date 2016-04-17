package br.edu.ifpb.ads.psd.projeto.dao;

import br.edu.ifpb.ads.psd.projeto.conexao.ClasseConexao;
import br.edu.ifpb.ads.psd.projeto.conexao.ConnectionFactory;
import br.edu.ifpb.ads.psd.projeto.entidades.Amizade;
import br.edu.ifpb.ads.psd.projeto.interfaces.AmizadeDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AmizadeDao implements AmizadeDaoIF {

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public AmizadeDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }

    public void inserir(Amizade amizade) throws SQLException {

        try {
            conexao.abrir();

            String SQL = "INSERT INTO Amizade(emailUsuario, emailAmigo, isAmigo, since) VALUES (?,?,?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, amizade.getEmailUsuario());
            pstm.setString(2, amizade.getEmailAmigo());
            pstm.setBoolean(3, amizade.isAmigo());
            pstm.setDate(4, amizade.getSince());

            pstm.executeUpdate();

        } finally {
            conexao.liberar();
        }
    }

    public void remover(Amizade amizade) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "DELETE FROM Amizade WHERE emailUsuario= ? AND emailAmigo= ?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, amizade.getEmailUsuario());
            pstm.setString(2, amizade.getEmailAmigo());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } finally {
            conexao.liberar();
        }
    }

    public void atualizar(Amizade amizade) throws SQLException {

        try {
            conexao.abrir();

            String SQL = "UPDATE Amizade SET isAmigo= ? since = ? WHERE id=?";

            pstm = con.prepareStatement(SQL);
            pstm.setBoolean(1, !amizade.isAmigo());
            pstm.setDate(2, amizade.getSince());
            pstm.setInt(3, amizade.getId());
            pstm.executeUpdate();
        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
    }

    public Amizade pesquisar(String emailUsuario, String emailAmigo) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "SELECT * FROM Amizade WHERE emailUsuario = ? AND emailAmigo= ? AND isAmigo = ?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, emailUsuario);
            pstm.setString(2, emailAmigo);
            pstm.setBoolean(3, true);

            ResultSet result = pstm.executeQuery();

            Amizade amizade = new Amizade();

            while (result.next()) {
                amizade.setEmailUsuario(result.getString("emailUsuario"));
                amizade.setEmailAmigo(result.getString("emailAmigo"));
                amizade.setSince(result.getDate("since"));
                amizade.setIsAmigo(result.getBoolean("isAmigo"));
                amizade.setId(result.getInt("id"));
            }
            return amizade;

        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }


    @Override
    public Amizade pesquisar(int id) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "SELECT * FROM Amizade WHERE id = ?";

            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, id);

            ResultSet result = pstm.executeQuery();

            Amizade amizade = new Amizade();

            while (result.next()) {
                amizade.setEmailUsuario(result.getString("emailUsuario"));
                amizade.setEmailAmigo(result.getString("emailAmigo"));
                amizade.setSince(result.getDate("since"));
                amizade.setIsAmigo(result.getBoolean("isAmigo"));
                amizade.setId(result.getInt("id"));
            }
            return amizade;

        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }


    @Override
    public ArrayList<Amizade> listar(String email) throws SQLException {
        try {
            conexao.abrir();

            String SQL = "SELECT * FROM Amizade WHERE emailUsuario = ? OR emailAmigo = ? AND isAmigo = ?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, email);
            pstm.setString(2, email);
            pstm.setBoolean(3, true);

            ResultSet result = pstm.executeQuery();

            ArrayList<Amizade> listaIdAmizades = new ArrayList<Amizade>();

            while (result.next()) {
                Amizade amizade = new Amizade();

                amizade.setEmailUsuario(result.getString("emailUsuario"));
                amizade.setEmailAmigo(result.getString("emailAmigo"));
                amizade.setSince(result.getDate("since"));
                amizade.setIsAmigo(result.getBoolean("isAmigo"));
                amizade.setId(result.getInt("id"));

                listaIdAmizades.add(amizade);
            }
            return listaIdAmizades;

        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
