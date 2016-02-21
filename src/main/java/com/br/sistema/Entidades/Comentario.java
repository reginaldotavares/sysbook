
package com.br.sistema.Entidades;

import java.sql.Timestamp;

public class Comentario {
  private int id;
  private String texto;
  private Usuario usuario;
  private Topico topico;
  
 public int getId() {
 	return id;
 }
 public void setId(int id) {
 	this.id = id;
 }
 public String getTexto() {
 	return texto;
 }
 public void setTexto(String texto) {
 	this.texto = texto;
 }
 
 public Usuario getUsuario() {
 	return usuario;
 }
 public void setUsuario(Usuario usuario) {
 	this.usuario = usuario;
 }
 public Topico getTopico() {
 	return topico;
 }
 public void setTopico(Topico topico) {
 	this.topico = topico;
 }
 
  
}

