package nl.edsard.resti.demo;

import org.springframework.stereotype.Repository;

@Repository
public class SensorsDAO {

    private static Sensors list = new Sensors();

    static
    {
        // and adding them to the list
        list.getSensorList().add(new Sensor(131,"temp_attic"));
        list.getSensorList().add(new Sensor(241,"temp_basement"));
        list.getSensorList().add(new Sensor(322,"temp_living"));
        
    }

    public Sensors getAllSensors(){

        return list;
    }

    public void addSensor(Sensor sensor)
    {
    list.getSensorList()
        .add(sensor);
       
    }

    public Sensor getById(int sensorId){
        if(sensorId < list.getSensorList().size()){
            return list.getSensorList().get(sensorId);
        }else{
            return null;
        }
    }

}
