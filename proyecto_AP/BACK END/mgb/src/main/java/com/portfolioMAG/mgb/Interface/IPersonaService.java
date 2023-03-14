package com.portfolioMAG.mgb.Interface;

import com.portfolioMAG.mgb.Entity.Persona;
import java.util.List


public interface IPersonaService {

    public List <Persona> getPerson();
    //guardar un objeto del tipo persona//
    public void savePersona(Persona persona);
    //eliminr un objeto pero lo buscamos por id//
    public void deletePersona(Long id);
    //buscar una persona por id//
    public Persona findPersona(Long id)
}
