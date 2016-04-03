/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.psd.projeto.servlets;

import br.edu.ifpb.ads.psd.projeto.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

/**
 *
 * @author jederson
 */
public class PesquisarUsuario extends HttpServlet {

    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UnsupportedEncodingException {

        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("searchUser");

        RequestDispatcher dispatcher = request.getRequestDispatcher("listarBusca.jsp");

        List lista = new ArrayList();
        try {
            lista = usuarioGer.pesquisarUsuario(nome);
        } catch (SQLException ex) {
            Logger.getLogger(PesquisarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("lista", lista);
        dispatcher.forward(request, response);
    }

}
