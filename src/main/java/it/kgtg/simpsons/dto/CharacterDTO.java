package it.kgtg.simpsons.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CharacterDTO extends BaseDTO {

    private String id;
    private String fistName;
    private String lastName;
    private String pictureURL;
    private int age;

}
