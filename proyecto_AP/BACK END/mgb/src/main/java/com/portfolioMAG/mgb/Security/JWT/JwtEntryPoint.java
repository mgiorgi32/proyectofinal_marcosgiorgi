/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioMAG.mgb.Security.JWT;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServiceRequest;
import javax.servlet.http.HttpServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    
    @override
    public void commence(HttpServiceRequest request, HttpServiceResponse response, AuthenticationException authException){
        logger.error("fallo el metodo commence");
        response.sendError(httpServiceResponse.SC UNAUTHORIZED);
    
    }
}
