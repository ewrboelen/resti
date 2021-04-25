package nl.edsard.resti.demo;

import java.util.Date;
import java.util.List;

public class Casus {
    
    private Integer id;
    private Date eersteAOdag;
    private Date aanmaakDatum;
    private Date maxZW;
    private Date casusAfgesloten;
    private String kantoorReferentie;
    private String burgerServiceNummer;
    private String version;
    private List<CasusHistorie> historie;

    public Casus() {
    }

    public Casus(Date eersteAOdag, String kantoorReferentie, String burgerServiceNummer) {
        this.eersteAOdag = eersteAOdag;
        this.kantoorReferentie = kantoorReferentie;
        this.burgerServiceNummer = burgerServiceNummer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(Date aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }

    public Date getMaxZW() {
        return maxZW;
    }

    public void setMaxZW(Date maxZW) {
        this.maxZW = maxZW;
    }

    public Date getCasusAfgesloten() {
        return casusAfgesloten;
    }

    public void setCasusAfgesloten(Date casusAfgesloten) {
        this.casusAfgesloten = casusAfgesloten;
    }

    public List<CasusHistorie> getHistorie() {
        return historie;
    }

    public void setHistorie(List<CasusHistorie> historie) {
        this.historie = historie;
    }

    public Date getEersteAOdag() {
        return eersteAOdag;
    }
    public void setEersteAOdag(Date eersteAOdag) {
        this.eersteAOdag = eersteAOdag;
    }
    public String getKantoorReferentie() {
        return kantoorReferentie;
    }
    public void setKantoorReferentie(String kantoorReferentie) {
        this.kantoorReferentie = kantoorReferentie;
    }
    public String getBurgerServiceNummer() {
        return burgerServiceNummer;
    }
    public void setBurgerServiceNummer(String burgerServiceNummer) {
        this.burgerServiceNummer = burgerServiceNummer;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    
    
}
