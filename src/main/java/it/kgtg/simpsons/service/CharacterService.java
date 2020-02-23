package it.kgtg.simpsons.service;

import it.kgtg.simpsons.converter.CharacterConverter;
import it.kgtg.simpsons.dto.CharacterDTO;
import it.kgtg.simpsons.model.Character;
import it.kgtg.simpsons.repository.CharacterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class CharacterService {

    private final CharacterConverter characterConverter;
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterConverter characterConverter, CharacterRepository characterRepository) {
        this.characterConverter = characterConverter;
        this.characterRepository = characterRepository;
    }

    public CharacterDTO getCharacter(String characterId) {
        log.debug("Searching for character with id: {}", characterId);
        Character entity = characterRepository.findById(characterId)
                                              .orElseThrow(() -> new IllegalStateException("Could not find character with specified id"));
        return characterConverter.createFrom(entity);
    }

    public List<CharacterDTO> getCharacters() {
        Collection<Character> entities = characterRepository.findAll();
        return characterConverter.createFromEntities(entities);
    }

}
