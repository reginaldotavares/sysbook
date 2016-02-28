package br.edu.ifpb.ads.psd.projeto.converterInformacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Reginaldo
 */
public class ConverterData {

    public java.sql.Date stringParaDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(formatter.parse(date).getTime());
        return data;
    }
    

}
