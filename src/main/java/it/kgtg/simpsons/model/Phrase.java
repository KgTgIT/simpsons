package it.kgtg.simpsons.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "phrases")
public class Phrase extends BaseEntity {

    private String character;
    private String phrase;

}
