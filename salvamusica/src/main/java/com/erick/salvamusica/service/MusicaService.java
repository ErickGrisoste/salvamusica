package com.erick.salvamusica.service;

import com.erick.salvamusica.dto.DeezerResponseDTO;
import com.erick.salvamusica.dto.MusicaDTO;
import com.erick.salvamusica.model.Musica;
import com.erick.salvamusica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicaService {
    private final String ENDERECO = "https://api.deezer.com/search?q=";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverterDados converte = new ConverterDados();
    @Autowired
    private MusicaRepository musicaRepository;

    public List<MusicaDTO> buscar(String termo){
        String url =  ENDERECO + termo;
        var json = consumo.obterDados(url);
        DeezerResponseDTO response = converte.obterDados(json, DeezerResponseDTO.class);

        return response.data();
    }

    public void salvarMusicas(String termo){
        List<MusicaDTO> listaDeMusicas = buscar(termo);
        List<Musica> musicas = listaDeMusicas.stream().map(Musica::new).toList();
        musicas.forEach(musica -> musicaRepository.save(musica));
    }

}
