package it.kgtg.simpsons.config;

import it.kgtg.simpsons.model.Character;
import it.kgtg.simpsons.model.Phrase;
import it.kgtg.simpsons.repository.CharacterRepository;
import it.kgtg.simpsons.repository.PhraseRepository;
import it.kgtg.simpsons.utils.SimpsonUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

import javax.annotation.PostConstruct;
import java.util.List;

@Profile("dev")
@DependsOn("mongoTemplate")
@Configuration
public class InitializeEmbeddedMongo {

    private static final String CHARACTERS_JSON = "characters.json";
    private static final String PHRASES_JSON = "phrases.json";

    private final MongoTemplate mongoTemplate;
    private final CharacterRepository characterRepository;
    private final PhraseRepository phraseRepository;

    public InitializeEmbeddedMongo(MongoTemplate mongoTemplate, CharacterRepository characterRepository, PhraseRepository phraseRepository) {
        this.mongoTemplate = mongoTemplate;
        this.characterRepository = characterRepository;
        this.phraseRepository = phraseRepository;
    }

    @PostConstruct
    public void initialize() {
        loadData();
        initializeIndexes();
    }

    private void loadData() {
        List<Character> characters = SimpsonUtils.readJSON(CHARACTERS_JSON, Character.class);
        characterRepository.saveAll(characters);

        List<Phrase> phrases = SimpsonUtils.readJSON(PHRASES_JSON, Phrase.class);
        phraseRepository.saveAll(phrases);
    }

    private void initializeIndexes() {
        Index characterIndex = new Index().on("character", Sort.Direction.ASC);
        mongoTemplate.indexOps(Phrase.class)
                     .ensureIndex(characterIndex);
    }

}
