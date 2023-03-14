
package com.portfolioMAG.mgb.Service;

import com.portfolioMAG.mgb.Entity.Persona;
import com.portfolioMAG.mgb.Repository.IPersonaRepository;
import static java.time.OffsetTime.now;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class ImpPersonaService implement IPersonaService{
   @Autovired IPersonaRepository ipersonarepository;
    
    @Override
    public List<Persona> getPersona(){
        List<Persona> persona=ipersonarepository.findAll()
                return persona;
    }
        @Override
    public void savePersona(Persona Persona){
        ipersonarepository.save(persona)
    }
        @Override
    public void deletePersona(Long id){
        ipersonarepository.deleteById(id);
    }
        @Override
    public Persona findPersona(Long id){
        Persona persona = ipersonarepository.findById(id).orElse(null)
                return persona
    }
    
}
