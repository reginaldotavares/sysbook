
package br.edu.ifpb.ads.psd.projeto.entidades;

public class Autores {
    private String nomeAutor;
    private String isbnLivro;

    public Autores() {
    }

    public Autores(String nomeAutor, String isbnLivro) {
        this.nomeAutor = nomeAutor;
        this.isbnLivro = isbnLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public void setIsbnLivro(String isbnLivro) {
        this.isbnLivro = isbnLivro;
    }
    
    
}
