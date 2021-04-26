package nl.edsard.resti.demo;

import java.util.ArrayList;
import java.util.List;

public class Sensors {
    private List<Sensor> sensorList;
  
    // Method to return the list sensors
    public List<Sensor> getSensorList()
    {
  
        if (sensorList == null) {
  
            sensorList  = new ArrayList<Sensor>();
        }
  
        return sensorList;
     }
  
    public void setSensorList( List<Sensor> sensorList)
    {
        this.sensorList = sensorList;
    }
    
}
