/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioMAG.mgb.Repository;

import com.portfolioMAG.mgb.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, integer> {
     public optional<Educacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
