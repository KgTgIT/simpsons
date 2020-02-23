package it.kgtg.simpsons.repository;

import it.kgtg.simpsons.model.Phrase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhraseRepository extends MongoRepository<Phrase, String> {

    List<Phrase> findAllByCharacter(String characterId);

}
