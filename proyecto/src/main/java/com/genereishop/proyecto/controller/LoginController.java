package com.genereishop.proyecto.controller;

import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.genereishop.proyecto.config.JwtFilter;
import com.genereishop.proyecto.dto.LoginResponse;
import com.genereishop.proyecto.modelo.User;
import com.genereishop.proyecto.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
    
    private final UserService userService;
    
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public LoginResponse loginUser(@RequestBody User user) throws ServletException {
        // Llama a validateUser desde el servicio
        if (userService.validateUser(user)) {
            // Busca el nombre del usuario desde la base de datos
            String userName = userService.getUserNameByEmail(user.getUserEmail());
            String email = user.getUserEmail();
            // Genera el token
            String token = generateToken(user.getUserEmail());
            
            // Retorna la respuesta con el nombre y el token
            return new LoginResponse(token, userName, email);
        }
        throw new ServletException("Nombre de usuario o contraseña incorrectos [" +
                user.getUserEmail() + "]");
    }

    private String generateToken(String email) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 12);
        return Jwts.builder().setSubject(email).claim("role", "user")
                .setIssuedAt(new Date())
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
                .compact();
    }
}