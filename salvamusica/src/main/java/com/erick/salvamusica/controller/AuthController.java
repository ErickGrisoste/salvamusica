package com.erick.salvamusica.controller;

import com.erick.salvamusica.dto.LoginDTO;
import com.erick.salvamusica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        usuarioService.autenticar(loginDTO);
        return ResponseEntity.ok("Login realizado com sucesso!");
    }
}
