package nl.edsard.resti.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @Autowired
    private CasusesDAO casusDao;
    //String token = System.getEnv("ACCESS_TOKEN");
      
    @GetMapping("/")  
    public String welcome()   
    {  
      return "<html>resti service at <a href=\"api-page.html\">api-page</a></html>";  
    }  

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

    @GetMapping(
        path = "/casus/{casusId}", produces = "application/json")
    public Casus getCasus(@Parameter(description="casus id", required=true) @PathVariable int casusId)
    {
       return casusDao.getById(casusId);
       
    }

    @PostMapping(
        path = "/casus",
        consumes = "application/json",
        produces = "application/json")
     public ResponseEntity<Object> addCasus(
        @RequestBody Casus casus)
    {
        casus.setId(casusDao.getNewId() );
        casusDao.addCasus(casus);
  
        URI location = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(
                      casus.getId())
                  .toUri();
  
               return ResponseEntity
            .created(location)
            .build();
    }

    @DeleteMapping(
        path = "/casus/{casusId}", produces = "application/json")
    public void deleteCasus(@Parameter(description="casus id", required=true) @PathVariable int casusId)
    {
       casusDao.removeCasusById(casusId);
       
    }

    @PostMapping(
        path = "/casus/{casusId}/history",
        consumes = "application/json",
        produces = "application/json")
     public ResponseEntity<Object> addCasusHistory(@Parameter(description="casus id", required=true) @PathVariable int casusId,
        @RequestBody CasusHistorie casusHistory)
    {

        Casus casus = casusDao.getById(casusId);
        casusHistory.setCasusId(casusId);
        casusHistory.setId(casus.getHistorie().size() );
        casus.getHistorie().add(casusHistory);
        //casus.setId(casusDao.getNewId() );
        //casusDao.addCasus(casus);
  
        
        URI location = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(
                    casusHistory.getId())
                  .toUri();
        
               return ResponseEntity
            .created(location)
            .build();
            
    }
    
}
