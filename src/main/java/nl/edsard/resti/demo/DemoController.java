package nl.edsard.resti.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Parameter;

@RestController 
public class DemoController {

    @Autowired
    private SensorsDAO sensorDao;
      
    //@RequestMapping("/")  
    //public String hello()   
    //{  
    //return "Hello world";  
    //}  

    @GetMapping(
        path = "/sensors", produces = "application/json")
    public Sensors getSensors()
    {
        return sensorDao.getAllSensors();
    }

    @GetMapping(
        path = "/sensor/{sensorId}", produces = "application/json")
    public Sensor getSensor(@Parameter(description="sensor id", required=true) @PathVariable int sensorId)
    {
        return sensorDao.getById(sensorId);
    }

    @GetMapping(
        path = "/sensors/latest", produces = "application/json")
    public Sensor getLatest()
    {
        return sensorDao.getAllSensors().getSensorList().get(1);
    }

    @PostMapping(
        path = "/sensor",
        consumes = "application/json",
        produces = "application/json")
     public ResponseEntity<Object> addSensor(
        @RequestBody Sensor sensor)
    {
        // Creating an ID of an sensor
        Integer id = sensorDao.getAllSensors().getSensorList().size()+ 1;
  
        sensor.setId(id);
  
        sensorDao.addSensor(sensor);
  
        URI location = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(
                      sensor.getId())
                  .toUri();
  
               return ResponseEntity
            .created(location)
            .build();
    }
    
}
