package br.unesp.soo.grupo1.redistutorial.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class News {
    private final String title;
    private final String content;
    private final String author;
}
