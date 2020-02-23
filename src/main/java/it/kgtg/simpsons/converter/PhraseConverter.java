package it.kgtg.simpsons.converter;

import it.kgtg.simpsons.dto.PhraseDTO;
import it.kgtg.simpsons.model.Phrase;
import org.springframework.stereotype.Component;

@Component
public class PhraseConverter implements GenericConverter<Phrase, PhraseDTO> {

    @Override
    public Phrase createFrom(PhraseDTO dto) {
        return updateEntity(new Phrase(), dto);
    }

    @Override
    public PhraseDTO createFrom(Phrase entity) {
        if (entity == null) {
            return null;
        }

        PhraseDTO phraseDTO = new PhraseDTO();
        phraseDTO.setId(entity.getId());
        phraseDTO.setCharacterId(entity.getCharacter());
        phraseDTO.setPhrase(entity.getPhrase());
        return phraseDTO;
    }

    @Override
    public Phrase updateEntity(Phrase entity, PhraseDTO dto) {
        entity.setPhrase(dto.getPhrase());
        entity.setCharacter(dto.getCharacterId());
        return entity;
    }

}
