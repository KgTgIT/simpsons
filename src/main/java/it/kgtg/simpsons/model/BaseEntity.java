package it.kgtg.simpsons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public abstract class BaseEntity {

    @Id
    @Field("_id")
    @JsonProperty("_id")
    private String id;

}
