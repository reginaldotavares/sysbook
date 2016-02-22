package br.edu.ifpb.ads.psd.projeto.entidades;

    public class Grupo {
        private int id ;
        private String emailUsuario;
        private String nome;
        private String descricao;

    public Grupo() {
    }

    public Grupo(int id, String emailUsuario, String nome, String descricao) {
        this.id = id;
        this.emailUsuario = emailUsuario;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
