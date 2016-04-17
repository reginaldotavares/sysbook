/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.psd.projeto.servlets;

import br.edu.ifpb.ads.psd.projeto.entidades.Amizade;
import br.edu.ifpb.ads.psd.projeto.entidades.Usuario;
import br.edu.ifpb.ads.psd.projeto.gerenciadores.GerenciadorDeAmizade;
import br.edu.ifpb.ads.psd.projeto.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;import javax.servlet.RequestDispatcher;
;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jederson
 */
public class AbrirUsuario extends HttpServlet {
    
    private GerenciadorDeUsuario usuarioGer = new GerenciadorDeUsuario();  
    private GerenciadorDeAmizade amizadeGer = new GerenciadorDeAmizade();

 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
        try{
            Usuario u = usuarioGer.getUsuario(id);
           // Amizade amizade = amizadeGer.adicionarAmizade(u, u)
            request.setAttribute("convidado",u);
            dispatcher.forward(request, response);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    
    

}
