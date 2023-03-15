
package com.portfolioMAG.mgb.Security.JWT;

import com.portfolioMAG.mgb.Security.entity.UsuarioPrincipal;
import java.security.SignatureException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.secret}")
    private int expiration;
    
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+expiration*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
       
    }
    
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser() .setSigningkey(secret) .parseClaimJws(token) .getBody() .getSunject();
        
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parser() .setSigningKey(secret) .parseClaimJws(token);
            return true;
        }catch(MalformedJwtException e){
            logger.error("Token mal formado");
        }catch(UnsupportedJwtException e){
            logger.error("Token no soportado");
        }catch(ExpiredJwtException e){
            logger.error("Token expirado");
        }catch(IllegalArgumentException e){
            logger.error("Token vacio");
        }catch(SignatureException e){
            logger.error("Firma no valida");
        }
        return false
    }
}

