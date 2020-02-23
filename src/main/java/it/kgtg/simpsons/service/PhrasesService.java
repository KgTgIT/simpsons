package it.kgtg.simpsons.service;

import it.kgtg.simpsons.converter.PhraseConverter;
import it.kgtg.simpsons.dto.CreatePhraseDTO;
import it.kgtg.simpsons.dto.PhraseDTO;
import it.kgtg.simpsons.model.Phrase;
import it.kgtg.simpsons.repository.PhraseRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PhrasesService {

    private final PhraseConverter phraseConverter;
    private final PhraseRepository phraseRepository;

    public PhrasesService(PhraseConverter phraseConverter, PhraseRepository phraseRepository) {
        this.phraseConverter = phraseConverter;
        this.phraseRepository = phraseRepository;
    }

    public PhraseDTO getPhrase(String phraseId) {
        log.debug("Searching for phrase with id: {}", phraseId);
        Phrase phrase = phraseRepository.findById(phraseId)
                                        .orElseThrow(() -> new IllegalStateException("Could not find phrase with specified id"));
        return phraseConverter.createFrom(phrase);
    }

    public List<PhraseDTO> getCharacterPhrases(String characterId) {
        List<Phrase> characterPhrases = phraseRepository.findAllByCharacter(characterId);
        return phraseConverter.createFromEntities(characterPhrases);
    }

    public PhraseDTO createPhrase(CreatePhraseDTO createPhraseDTO) {
        Phrase phrase = new Phrase();
        phrase.setId(ObjectId.get().toHexString());
        phrase.setCharacter(createPhraseDTO.getCharacterId());
        phrase.setPhrase(createPhraseDTO.getPhrase());

        Phrase savedPhrase = phraseRepository.insert(phrase);
        return phraseConverter.createFrom(savedPhrase);
    }

    public void removePhrase(String phraseId) {
        phraseRepository.deleteById(phraseId);
    }

}
