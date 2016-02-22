/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.ads.psd.projeto.entidades;

import java.sql.Timestamp;

/**
 *
 * @author Reginaldo
 */
public class FotoLivro {
  private String url;
  private Timestamp data;
  private Usuario usuario;
  
 public String getUrl() {
 	return url;
 }
 public void setUrl(String url) {
 	this.url = url;
 }
 public Timestamp getData() {
 	return data;
 }
 public void setData(Timestamp data) {
 	this.data = data;
 }
 public Usuario getUsuario() {
 	return usuario;
 }
 public void setUsuario(Usuario usuario) {
 	this.usuario = usuario;
 }
 
}
