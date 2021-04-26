package nl.edsard.resti.demo;

import java.util.ArrayList;
import java.util.List;

public class Casuses {
    private List<Casus> casusList;
  
    public Casuses() {
        casusList  = new ArrayList<Casus>();
    }

    public List<Casus> getCasusList()
    {
        return casusList;
     }
  
    public void setCasusList( List<Casus> casusList)
    {
        this.casusList = casusList;
    }
}
