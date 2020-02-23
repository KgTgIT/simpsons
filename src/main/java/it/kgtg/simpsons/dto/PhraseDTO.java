package it.kgtg.simpsons.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PhraseDTO extends BaseDTO {

    private String id;
    private String characterId;
    private String phrase;

}
