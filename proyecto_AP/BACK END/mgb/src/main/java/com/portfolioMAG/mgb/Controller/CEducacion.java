/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioMAG.mgb.Controller;

import com.portfolioMAG.mgb.DTO.DtoEducacion;
import com.portfolioMAG.mgb.Entity.Educacion;
import com.portfolioMAG.mgb.Security.Controller.Mensaje;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import static org.jboss.logging.NDC.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edu")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    @SEducacion sEducacion ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> List() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/(id)")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje ("no existe el id"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreE(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoedu.getNombreE(), dtoedu.getDescripcionE());

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);

    }
@PutMapping("/update/(id)")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.exsistByNomreE(dtoedu.getNombreE()) && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id)
        get();
        educacion.getNombreE(dtoexp.getNombreE());
        educacion.setDescripcionE(dtoexp.getDescripcionE());

        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actulizada"), HttpStatus.OK);

    }
    public ResponseEntity<?> delete(@pathVariable("id") int id){
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
            
            sEducacion.delete(id);
            return new ResponseEntity(new Mensaje ("Educacion eliminada"), HttpSatuts.OK);
    }
}
