package br.edu.ifpb.ads.psd.projeto.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpb.ads.psd.projeto.gerenciadores.GerenciadorDeLivros;
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


public class ListarLivros extends HttpServlet {
    private GerenciadorDeLivros livroGer = new GerenciadorDeLivros();

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
        request.setCharacterEncoding("UTF-8");
        HttpSession session  =  request.getSession();
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarLivros.jsp");
        List listaLivros = new ArrayList();
        try {
            listaLivros = livroGer.listarLivros();
            session.setAttribute("listaLivros", listaLivros);
  
        dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ListarLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
