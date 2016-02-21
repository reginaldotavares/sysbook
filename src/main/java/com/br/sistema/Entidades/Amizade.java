package com.br.sistema.Entidades;
   
public class Amizade {
        private int id;
        private String emailUsuario;
        private String emailAmigo;

    public Amizade() {
    }

    public Amizade(int id, String emailUsuario, String emailAmigo) {
        this.id = id;
        this.emailUsuario = emailUsuario;
        this.emailAmigo = emailAmigo;
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

    public String getEmailAmigo() {
        return emailAmigo;
    }

    public void setEmailAmigo(String emailAmigo) {
        this.emailAmigo = emailAmigo;
    }

    
}

