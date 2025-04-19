package com.erick.salvamusica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeezerResponseDTO(List<MusicaDTO> data) {
}
