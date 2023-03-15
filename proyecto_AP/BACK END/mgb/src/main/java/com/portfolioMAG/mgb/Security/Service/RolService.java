
package com.portfolioMAG.mgb.Security.Service;

import com.portfolioMAG.mgb.Security.Enums.RolNombre;
import com.portfolioMAG.mgb.Security.entity.Rol;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    @RolRepository rolRepository
            
            public Optional<Rol> getByNombre(RolNombre rolNombre){
                return rolRepository.findByRolNombre(rolNombre)
            }
            public void save(Rol rol){
                rolRepository.save(rol)
            }
}
