package it.kgtg.simpsons.repository;

import it.kgtg.simpsons.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {

}
