
package com.portfolioMAG.mgb.Security.JWT;

import com.portfolioMAG.mgb.Security.Service.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtTokenFilter extends OncePerRequestFilter{
     private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
     
     @Autowired
     JwtProvider jwtProvider;
     @Autowired
     UserDetailsImpl userDetailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = getToken(request);
            if(token!= null && jwtProvider.validateToken(token));{
            String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
            UserDetails userDetails = userDetailsServiseImpl.loadUserByusername(nombreUsuario);
            UsernamePasseordAuthenticationToken auth = new UsernamepasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());  
            SecurityContenxtHolder.getContext().setAuthentication(auth);
        }
        }catch (exception e){
                logger.error("fallo el metodo doFilterInternal");
                }
        filterChain.doFilter(request, response);
    }
     private String getToken(HttpServletRequest request){
         String header= request.getHeader("Authorization");
         if(header != null && header.startsWith("bearer"))
             return header.replace("bearer", "");
         return null;
     }
}
