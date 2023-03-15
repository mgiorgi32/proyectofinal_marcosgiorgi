/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioMAG.mgb.Security.Controller;

import com.portfolioMAG.mgb.Security.DTO.JwtDto;
import com.portfolioMAG.mgb.Security.DTO.LoginUsuario;
import com.portfolioMAG.mgb.Security.Enums.RolNombre;
import static com.portfolioMAG.mgb.Security.Enums.RolNombre.ROLE_ADMIN;
import com.portfolioMAG.mgb.Security.JWT.JwtProvider;
import com.portfolioMAG.mgb.Security.Service.RolService;
import com.portfolioMAG.mgb.Security.Service.UsuarioService;
import com.portfolioMAG.mgb.Security.entity.Rol;
import com.portfolioMAG.mgb.Security.entity.Usuario;
import jakarta.validation.Valid;
import java.util.HashSet;
import static org.jboss.logging.NDC.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.passwordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
     AuthenticationManager authenticationManager;
    @Autowired
     UsuarioService usuarioService;  
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResults bndingResults){
        if (bindingResults.hasErrors()){
            return new ResponsEntity(new Mensaje("campo mal puesto o email invalido"), HttpStatus.BAD_REQUEST);
        
            
            if(usuarioService.existByNombreUsuario(nombreUsuario.getNombreUsuario()){
                return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
            }
            if(usuarioService.existByEmail(nombreUsuario.getEmail()){
                return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
            }
            Usuario usuario = new Usuario(nuevoUsuario.getNombre()); nuevoUsuario.getNombreUsuario(); nuevousuario.getEmail(); passwordEncoder.encode(nuevoUsuario.getPassword());
            
            set<Rol> roles = new HashSet<>();
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
            if(nuevoUsuario.getRoles().contains("admin"))
                roles.add(rolService.getByRolNombre(RolNombre:ROLE_ADMIN).get());
                usuario.setRoles(roles);
                usuarioService.save(usuario);
                
                return new ResponseEntity(new Mensaje("usuario guardado"); HttpStatus.CREATED)
        }
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResults bindingResults)
            if(bindingResults.hasErrors()){
        return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication= authenticationManager.authenticate(new UsernamePaswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword());
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        Strin jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetail.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK)
    }
}
