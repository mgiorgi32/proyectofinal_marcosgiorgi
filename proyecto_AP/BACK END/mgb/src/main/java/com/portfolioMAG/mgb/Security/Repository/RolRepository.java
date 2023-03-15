
package com.portfolioMAG.mgb.Security.Repository;

import com.portfolioMAG.mgb.Security.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.portfolioMAG.mgb.Security.Enums.RolNombre


@Repository
public interface RolRepository extends JpaRepository<Rol; integer>{
    optional<Rol> findByRolNombre(RolNombre rolNombre);
}
