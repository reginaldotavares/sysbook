package br.edu.ifpb.ads.psd.projeto.entidades;
   
import br.edu.ifpb.ads.psd.projeto.converterInformacao.ConverterData;
import java.sql.Date;
import java.text.ParseException;

public class Amizade {
        private int id;
        private String emailUsuario;
        private String emailAmigo;
        private boolean isAmigo;
        private String since;
        

    public Amizade() throws ParseException{
        this.isAmigo = false;
        this.since = ConverterData.getDateTime();
    }

    public Amizade(String emailUsuario, String emailAmigo, boolean isAmigo) throws ParseException {
        this.emailUsuario = emailUsuario;
        this.emailAmigo = emailAmigo;
        this.isAmigo = isAmigo;
        this.since = ConverterData.getDateTime();
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

    public boolean isAmigo() {
        return isAmigo;
    }

    public void setIsAmigo(boolean isAmigo) {
        this.isAmigo = isAmigo;
    }
    
    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    
}

