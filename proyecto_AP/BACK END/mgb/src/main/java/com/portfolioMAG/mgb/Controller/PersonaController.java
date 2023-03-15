package com.portfolioMAG.mgb.Controller;

import com.portfolioMAG.mgb.Entity.Persona;
import com.portfolioMAG.mgb.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("personas/traer")
    public List<persona> getPersona(){
        return ipersonaservice.getPersona();
    }
    @PreAuthorize("hasRole("admin")")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaservice.savePersona(persona)
                return "la persona fue creada correctamente"
    }
    @PreAuthorize("hasRole("admin")")
    @DeleteMapping("/personas/borrar/(id)"){
    public String deletePersona(@PathVariable Long id)
            ipersonaservice.deletePersona(id)
    return "la persona fue eliminada correctamente"
}
@PreAuthorize("hasRole("admin")")
@PutMapping("/personas/editar/(id)")
public Persona editPersona(@PathVariable Long id)
                           @RequestParam("nombre") String nuevoNombre;
                           @RequestParam("apellido") String nuevoApellido;
                           @RequestParam("img") String nuevoImg;
     Persona persona = ipersonaservice.findPersona(id);
     persona.setNombre(nuevoNombre)
     persona.setApellido(nuevoApellido)
     persona.setImg(nuevoImg)
ipersonaservice.savePersona(persona);
reurn persona;
}
}
