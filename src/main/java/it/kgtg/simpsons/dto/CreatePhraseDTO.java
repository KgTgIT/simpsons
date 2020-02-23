package it.kgtg.simpsons.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreatePhraseDTO {

    @NotNull(message = "Phrase text cannot be null!")
    private String phrase;

    @NotNull(message = "Character must be specified!")
    private String characterId;

    private String phraseId;

}
