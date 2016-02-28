package br.edu.ifpb.ads.psd.projeto.servlets;

import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import br.edu.ifpb.ads.psd.projeto.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarUsuario extends HttpServlet {

    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email.equals("admin@sysbook.com")){
            request.setAttribute("mensagem", "Usuário Admin, não pode ser excluído");
            response.sendRedirect("index.jsp");
        }

        Usuario user = new Usuario();
        try {
            user = usuarioGer.pesquisarUsuarioEmail(email);
            if (user.getEmail().equals(email) && user.getSenha().equals(password)) {
                usuarioGer.removerUsuario(email);
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("mensagem", "Senha incorreta");
                request.getRequestDispatcher("deletarUsuario.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeletarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
