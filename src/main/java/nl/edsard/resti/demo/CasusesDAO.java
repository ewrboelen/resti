package nl.edsard.resti.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class CasusesDAO {

    private static Casuses list = new Casuses();

    public void addCasus(Casus casus)
    {
        list.getCasusList().add(casus);
    }

    public int getNewId(){
        return list.getCasusList().size() + 1;
    }

    public Casus getById(int casusId){
        if(casusId < list.getCasusList().size()){
            return list.getCasusList().get(casusId);
        }else{
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    public void removeCasusById(int casusId){
        if(casusId < list.getCasusList().size()){
            list.getCasusList().remove(casusId);
        }else{
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }
    
}
