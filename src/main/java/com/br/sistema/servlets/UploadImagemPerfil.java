package com.br.sistema.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.br.sistema.Entidades.Usuario;
import com.br.sistema.Gerenciadores.GerenciadorDeUsuario;
import com.br.sistema.Gerenciadores.GerenciarFotos;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 *
 * @author Emanuel
 */
@WebServlet(name = "UploadImagemPerfil", urlPatterns = {"/upload-imagem-perfil"})
public class UploadImagemPerfil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        String caminho = getServletContext().getRealPath("/imagens");
        response.getWriter().print(caminho);
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
        Usuario usuario = ((Usuario) request.getSession().getAttribute("usuario"));
        if (usuario == null) {
            response.sendRedirect("");
        } else {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = null;
                try {
                    items = (List<FileItem>) upload.parseRequest(request);
                } catch (FileUploadException ex) {
                    Logger.getLogger(UploadImagemPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
                FileItem item = items.get(0);
                if (item != null) {
                    String nome_arquivo = String.valueOf(new Date().getTime())+item.getName();
                    String caminho = getServletContext().getRealPath("/imagens") + "\\" + usuario.getId() + "\\";
                    File file = new File(caminho);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File uploadedFile = new File(caminho + nome_arquivo);
                    try {
                        item.write(uploadedFile);
                    } catch (Exception ex) {
                        Logger.getLogger(UploadImagemPerfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    GerenciadorDeUsuario gerenciarUsuario = new GerenciadorDeUsuario();
                    try {
                        gerenciarUsuario.atualizarFotoPerfil("imagens" + "/" + usuario.getId()+"/"+ nome_arquivo, usuario.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(UploadImagemPerfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    GerenciarFotos gerenciarFotos = new GerenciarFotos();
                    try {
                        gerenciarFotos.publicarFoto("imagens" + "/" + usuario.getId()+"/"+ nome_arquivo, usuario);
                    } catch (SQLException ex) {
                        Logger.getLogger(UploadImagemPerfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        usuario = gerenciarUsuario.getUsuario(usuario.getId());
                    } catch (SQLException ex) {
                        Logger.getLogger(UploadImagemPerfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.getSession().setAttribute("usuario", usuario);
                    response.sendRedirect("configuracao");
                }else{
                    
                }
            }

        }
    }

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
