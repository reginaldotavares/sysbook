package com.br.sistema.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.br.sistema.Entidades.Livro;
import com.br.sistema.Gerenciadores.GerenciadorDeLivros;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EncontrarLivros extends HttpServlet {

    private GerenciadorDeLivros livroGer = new GerenciadorDeLivros();

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String titulo = request.getParameter("titulo");

        Livro livro = new Livro();

        try {
            livro = livroGer.pesquisarLivro(titulo);
        request.setAttribute("livro", livro);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("ResultadoBuscaLivro.jsp");

        dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(EncontrarLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
