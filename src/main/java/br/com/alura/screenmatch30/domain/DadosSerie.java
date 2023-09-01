package br.com.alura.screenmatch30.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(
        @JsonAlias("Title")
        String titulo,
        @JsonAlias("totalSeasons")
        Integer totalTemporadas,
        @JsonAlias("imdbRating")
        String avaliacao) {
}
