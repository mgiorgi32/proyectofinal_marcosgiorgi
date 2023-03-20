
package com.portfolioMAG.mgb.Service;

import com.portfolioMAG.mgb.Entity.Persona;
import com.portfolioMAG.mgb.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpPersonaService {
   @Autowired IPersonaRepository ipersonarepository;
     public List<Persona> List(){
        
        return ipersonarepository.findAll();
        
    }
    public Optional<Persona> getOne(int id){
        return ipersonarepository.findById(id);
        
    }
    public Optional<Persona> getByNombre(String nombre){
        return ipersonarepository.findByNombre(nombre);
        
    }
    public void save(Persona expe){
        ipersonarepository.save(expe);
        
    }
    public void delete(int id){
        ipersonarepository.deleteById(id);
    }
    public boolean existsById(int id){
        return ipersonarepository.existsById(id);
    }
    public boolean existsByNombre(String nombre){
            return ipersonarepository.existsByNombre(nombre);
    }

    
}
