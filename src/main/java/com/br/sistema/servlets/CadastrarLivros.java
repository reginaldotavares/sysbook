package com.br.sistema.servlets;


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


public class CadastrarLivros extends HttpServlet {

  private GerenciadorDeLivros livroGer = new GerenciadorDeLivros();

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
       
        String isbn= request.getParameter("isbn");
        String titulo= request.getParameter("titulo");
        Integer anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));
        String editora = request.getParameter("editora");
        String fotoCapa = request.getParameter("fotoCapa");
        String tema = request.getParameter("tema");
  
      try {
          livroGer.adicionarLivros(isbn, titulo, anoPublicacao, editora, fotoCapa, tema);
      
        request.setAttribute("livro", livroGer);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");

        dispatcher.forward(request, response);

      } catch (SQLException ex) {
          Logger.getLogger(CadastrarLivros.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}


   