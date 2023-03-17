/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioMAG.mgb.Service;

import com.portfolioMAG.mgb.Entity.Experiencia;
import com.portfolioMAG.mgb.Repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    @Autowired
    RExperiencia rExperiencia
            
    public List<Experiencia> List(){
        
        return rExperiencia.findAll();
        
    }
    public Optional<Experiencia> getOne(List id){
        return rExperiencia.findById(id);
        
    }
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);
        
    }
    public void save(Experiencia expe){
        rExperiencia.save(expe);
        
    }
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    public boolean existsById(id){
        return rExperiencia.existsById(id);
    }
    public boolean existsByNombreE(String nombreE)
            return rExperiencia.existsByNombreE(nombreE);
}
