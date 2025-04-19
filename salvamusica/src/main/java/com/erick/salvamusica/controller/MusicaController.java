package com.erick.salvamusica.controller;

import com.erick.salvamusica.dto.MusicaDTO;
import com.erick.salvamusica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaService service;

    @GetMapping("/buscar")
    public ResponseEntity<List<MusicaDTO>> buscar(@RequestParam String termo){
        return ResponseEntity.ok(service.buscar(termo));
    }

    @GetMapping("/salvar")
    public void salvarMusicas(@RequestParam String termo){
        service.salvarMusicas(termo);
    }
}
