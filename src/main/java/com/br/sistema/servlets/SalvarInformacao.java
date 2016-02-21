package com.br.sistema.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.br.sistema.ConverterInformacao.ConverterData;
import com.br.sistema.Entidades.Usuario;
import com.br.sistema.Gerenciadores.GerenciadorDeUsuario;
import com.br.sistema.validacao.UsuarioInforValidacao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @Reginaldo
 */
public class SalvarInformacao extends HttpServlet {
ConverterData converter = new ConverterData();
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("configuracao");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Usuario usuario = ((Usuario) request.getSession().getAttribute("usuario"));
        if (usuario == null) {
            response.sendRedirect("");
        } else {
            String email = request.getParameter("email");
            String nome = request.getParameter("nome");
            String apelido = request.getParameter("apelido");
            String senha = request.getParameter("senha");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String data_nascimento = request.getParameter("datanascimento");
            String tipo = request.getParameter("tipo");

            UsuarioInforValidacao usuarioInforValidacao = new UsuarioInforValidacao();
            List<String> mensagensErros = usuarioInforValidacao.validar(nome, nome, apelido, data_nascimento, cidade, email, tipo, senha, estado);
            if (mensagensErros == null) {
                GerenciadorDeUsuario gerenciarUsuario = new GerenciadorDeUsuario();
                boolean emailExistente = false;
                try {
                    emailExistente = gerenciarUsuario.verificarExistenciaEmail(email);
                } catch (Exception ex) {
                    Logger.getLogger(SalvarInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!usuario.getEmail().equals(email) && emailExistente) {
                    mensagensErros = new LinkedList<>();
                    mensagensErros.add("Email Existente");
                }
            }
            if ( mensagensErros==null || mensagensErros.isEmpty()) {
                try {
                    GerenciadorDeUsuario gerenciarUsuario = new GerenciadorDeUsuario();
                    try {
                        gerenciarUsuario.adicionarUsuario(email, nome, apelido, senha, cidade, estado, tipo, converter.stringParaDate(data_nascimento));
                    } catch (SQLException ex) {
                        Logger.getLogger(SalvarInformacao.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalvarInformacao.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    usuario = gerenciarUsuario.getUsuario(usuario.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(SalvarInformacao.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("configuracao");
            } else {
                request.setAttribute("mensagensInformacao", mensagensErros);
                getServletContext().getRequestDispatcher("/configuracao").forward(request, response);
            }
        }
    }
}
