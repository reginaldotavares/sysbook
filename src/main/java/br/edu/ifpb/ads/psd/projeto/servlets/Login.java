package br.edu.ifpb.ads.psd.projeto.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import br.edu.ifpb.ads.psd.projeto.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Reginaldo
 */
public class Login extends HttpServlet {

    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
        Usuario usuario = new Usuario();
        try {
        usuario = usuarioGer.pesquisarUsuarioEmail(email);
        RequestDispatcher dispatcher = null;
           if (usuario.getEmail()==null){
               request.setAttribute("mensagem", "Usuário não cadastrado!");
                dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
           }else if((usuario.getEmail().equals(email)) && (usuario.getSenha().equals(senha))) {

            HttpSession session  =  request.getSession();
            session.setAttribute("usuario",usuario);
            dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            
            }else{
                request.setAttribute("mensagem", "Senha inválida");
                dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
