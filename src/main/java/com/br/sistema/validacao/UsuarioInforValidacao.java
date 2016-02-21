package com.br.sistema.validacao;


import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UsuarioInforValidacao {

    public List<String> validar(String email, String nome, String apelido, String senha, String cidade, String estado, String foto, String dataNascimento, String tipo) {
        List<String> mensagensErros = new LinkedList<>();
        
        try {
            validarEmail(email, "Email");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }
        try {
            validarTextoObrigatorio(nome, "Nome");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }
        try {
            validarTextoNaoObrigatorio(apelido, "Apelido");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }
        try {
            validarTextoSemCaracteresEspecial(senha, "Senha");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }
        try {
            validarTextoNaoObrigatorio(cidade, "Cidade");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }
        try {
            validarTextoNaoObrigatorio(estado, "Estado");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }
        try {
            validarData(dataNascimento, "Data de Nascimento");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }
        try {
            validarTextoNaoObrigatorio(tipo, "Tipo");
        } catch (Exception ex) {
            mensagensErros.add(ex.getMessage());
        }

        return mensagensErros.isEmpty() ? null : mensagensErros;

    }

    private void validarTextoObrigatorio(String texto, String campo) throws Exception {
        if (texto == null || !texto.matches("[A-ZÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ].*")) {
            throw new Exception(campo + " formato errado ou vazio!");
        }
    }

    private void validarTextoNaoObrigatorio(String texto, String campo) throws Exception {

        if (texto != null && texto.isEmpty()) {
            texto = null;
        } else if (texto != null && !texto.matches("[A-ZÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ].*")) {
            throw new Exception(campo + " formato errado!");
        }

    }

    private void validarTextoSemCaracteresEspecial(String texto, String campo) throws Exception {
        if (texto == null || !texto.matches("\\w+")) {
            throw new Exception("senha contém caracteres especiais ou esta vazia!");
        }
    }

    private void validarData(String data, String campo) throws Exception {
        if (data != null) {
            if (data.equals("")) {
                data = null;
            } else {
                if (data== null || !data.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                 throw new Exception("data no formato errado ou vazio!");   
                }
            }
        }
    }

    private void validarEmail(String email, String campo) throws Exception {
        if (email == null || !email.matches("\\w+@\\w+\\.\\w{2,3}")) {
            throw new Exception("e-mail formato errado ou vazio!");
        }
    }


}
