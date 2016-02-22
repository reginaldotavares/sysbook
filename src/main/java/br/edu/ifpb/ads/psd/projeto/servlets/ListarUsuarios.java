package br.edu.ifpb.ads.psd.projeto.servlets;

import br.edu.ifpb.ads.psd.projeto.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ListarUsuarios extends HttpServlet {
     private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        UsuarioDao dao = new UsuarioDao();
       request.setCharacterEncoding("UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarUsuarios.jsp");
        List lista = new ArrayList();
         try {
             lista = usuarioGer.listarUsuarios();
         } catch (SQLException ex) {
             Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
         }
        request.setAttribute("lista", lista);

        dispatcher.forward(request, response);

    }
}
