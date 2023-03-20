package com.portfolioMAG.mgb.Controller;

import com.portfolioMAG.mgb.DTO.dtoPersona;
import com.portfolioMAG.mgb.Entity.Persona;
import com.portfolioMAG.mgb.Security.Controller.Mensaje;
import com.portfolioMAG.mgb.Service.ImpPersonaService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import static org.jboss.logging.NDC.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins ="https://portfolio-784b6.web.app", "http://localhost:4200")
public class PersonaController {
    @Autowired ImpPersonaService personaService;
    @GetMapping("/lista")
     public ResponseEntity<List<Persona>> List() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/(id)")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   
  
@PutMapping("/update/(id)")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (personaService.exsistByNomreE(dtoPersona.getNombre()) && personaService.getByNombre(dtoPersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id){
        get();
      persona.setNombre(dtoPersona.getNombre());
      persona.setApellido(dtoPersona.getApellido());
      persona.setDescripcion(dtoPersona.getDescripcion());
      persona.setImg(dtoPersona.getImg());
        personaService.save(persona);{
        return new ResponseEntity(new Mensaje("skill actulizada"), HttpStatus.OK);

    }
    
}
