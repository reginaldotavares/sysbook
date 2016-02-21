package com.br.sistema.servlets;

import com.br.sistema.Gerenciadores.GerenciadorDeUsuario;
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
        try {
            usuarioGer.removerUsuario(email);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarUsuarios");

        dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(DeletarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
