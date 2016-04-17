package br.edu.ifpb.ads.psd.projeto.entidades;
   
import br.edu.ifpb.ads.psd.projeto.converterInformacao.ConverterData;
import java.sql.Date;
import java.text.ParseException;

public class Amizade {
        private int id;
        private String emailUsuario;
        private String emailAmigo;
        private boolean isAmigo;
        private Date since;
        

    public Amizade() {
    }

    public Amizade(int id, String emailUsuario, String emailAmigo) throws ParseException {
        this.id = id;
        this.emailUsuario = emailUsuario;
        this.emailAmigo = emailAmigo;
        this.isAmigo = false;
        this.since = ConverterData.stringParaDate(ConverterData.getDateTime());
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
    
    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    
}

