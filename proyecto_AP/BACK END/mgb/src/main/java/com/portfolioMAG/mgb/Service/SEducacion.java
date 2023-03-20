/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioMAG.mgb.Service;

import com.portfolioMAG.mgb.Entity.Educacion;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    @Autowired
    @REducacion rEducacion;
    
     public List<Educacion> List(){
        
        return rEducacion.findAll();
        
    }
    public Optional<Educacion> getOne(List id){
        return rEducacion.findById(id);
        
    }
    public Optional<Educacion> getByNombreE(String nombreE){
        return rEducacion.findByNombreE(nombreE);
        
    }
    public void save(Educacion edu){
        rEducacion.save(edu);
        
    }
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    public boolean existsById(id){
        return rEducacion.existsById(id);
    }
    public boolean existsByNombreE(String nombreE){
            return rEducacion.existsByNombreE(nombreE);
    }
}
