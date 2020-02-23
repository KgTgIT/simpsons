package it.kgtg.simpsons.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "characters")
public class Character extends BaseEntity {

    private String firstName;
    private String lastName;
    private String picture;
    private int age;

}
