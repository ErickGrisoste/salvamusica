package com.erick.salvamusica.controller;

import com.erick.salvamusica.dto.MusicaDTO;
import com.erick.salvamusica.model.Musica;
import com.erick.salvamusica.model.Usuario;
import com.erick.salvamusica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;


    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.cadastrar(usuario));
    }

    @PostMapping("/{usuarioId}/favoritar")
public ResponseEntity<?> favoritar(@PathVariable Long usuarioId, @RequestBody MusicaDTO musicaDTO){
        service.favoritarMusica(usuarioId, musicaDTO);
        return ResponseEntity.ok("Musica Favoritada!");
    }

    @GetMapping("/{usuarioId}/listarFavs")
    public List<Musica> listaMusicasFavs(@PathVariable Long usuarioId){
       return service.listarFavs(usuarioId);
    }
}
