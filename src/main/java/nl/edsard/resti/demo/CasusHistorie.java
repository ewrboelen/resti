package nl.edsard.resti.demo;

import java.util.Date;

public class CasusHistorie {
    
    private Integer id;
    private Integer casusId;
    private String opmerking;
    private Date aanmaakDatum;
    private String gebruiker;
    private String procesStap;

    public Integer getCasusId() {
        return casusId;
    }
    public void setCasusId(Integer casusId) {
        this.casusId = casusId;
    }
    public String getOpmerking() {
        return opmerking;
    }
    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }
    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }
    public void setAanmaakDatum(Date aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }
    public String getGebruiker() {
        return gebruiker;
    }
    public void setGebruiker(String gebruiker) {
        this.gebruiker = gebruiker;
    }
    public String getProcesStap() {
        return procesStap;
    }
    public void setProcesStap(String procesStap) {
        this.procesStap = procesStap;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}
