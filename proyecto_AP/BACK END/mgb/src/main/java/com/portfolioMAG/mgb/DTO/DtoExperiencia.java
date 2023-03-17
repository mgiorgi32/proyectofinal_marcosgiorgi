
package com.portfolioMAG.mgb.DTO;

import jakarta.validation.constraints.NotBlank;


public class DtoExperiencia {
    @NotBlank
   private String nombreE;
    @NotBlank
   private String descripcionE;


//constuctores

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    //getters y setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    

}