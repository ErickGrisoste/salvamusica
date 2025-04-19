package com.erick.salvamusica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicaDTO(String title, ArtistaDTO artist, int duration) {
}
