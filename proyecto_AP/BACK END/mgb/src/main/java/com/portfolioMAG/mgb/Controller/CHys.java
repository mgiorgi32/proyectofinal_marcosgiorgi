
package com.portfolioMAG.mgb.Controller;

import com.portfolioMAG.mgb.DTO.DtoHys;
import com.portfolioMAG.mgb.Entity.HyS;
import com.portfolioMAG.mgb.Security.Controller.Mensaje;
import com.portfolioMAG.mgb.Service.SHys;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import static org.jboss.logging.NDC.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ={"https://mgbfrontend.web.app", "https://localhost:4200"})
@RequestMapping("/skill")
public class CHys {
    @Autowired
    SHys shys;
    @GetMapping
     public ResponseEntity<List<HyS>> List() {
        List<HyS> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/(id)")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id){
        if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HyS hys = shys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    @DeleteMapping("/delete/(id)")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!shys.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        shys.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHys dtohys) {
        if (StringUtils.isBlank(dtohys.getNombreE())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shys.existsByNombreE(dtohys.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
        }
        Hys hys = new Hys(dtohys.getNombreE(), dtohys.getDescripcionE());

        return new ResponseEntity(new Mensaje("skill agregada"), HttpStatus.OK);

    }
@PutMapping("/update/(id)")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (shys.exsistByNomreE(dtohys.getNombreE()) && shys.getByNombreE(dtohys.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtohys.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Hys hys = shys.getOne(id)
        get();
        hys.getNombreE(dtohys.getNombreE());
        hys.setDescripcionE(dtohys.getDescripcionE());

        shys.save(hys);
        return new ResponseEntity(new Mensaje("skill actulizada"), HttpStatus.OK);

    }
    public ResponseEntity<?> delete(@pathVariable("id") int id){
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
            
            shys.delete(id);
            return new ResponseEntity(new Mensaje ("Skill eliminada"), HttpSatuts.OK);
    }
}
