package br.edu.ifpb.ads.psd.projeto.entidades;

import java.sql.Date;
import java.util.List;


public class Livro {
    
    private String isbn;
    private String titulo;
    private Integer anoPublicacao;
    private String editora;
    private String fotoCapa;
    private String tema;

    public Livro() {
    }

    public Livro(String isbn, String titulo, Integer anoPublicacao, String editora, String fotoCapa, String tema) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.fotoCapa = fotoCapa;
        this.tema = tema;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getFotoCapa() {
        return fotoCapa;
    }

    public void setFotoCapa(String fotoCapa) {
        this.fotoCapa = fotoCapa;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    

}