package it.kgtg.simpsons.converter;

import it.kgtg.simpsons.dto.CharacterDTO;
import it.kgtg.simpsons.model.Character;
import org.springframework.stereotype.Component;

@Component
public class CharacterConverter implements GenericConverter<Character, CharacterDTO> {

    @Override
    public Character createFrom(CharacterDTO dto) {
        return updateEntity(new Character(), dto);
    }

    @Override
    public CharacterDTO createFrom(Character entity) {
        if (entity == null) {
            return null;
        }

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(entity.getId());
        characterDTO.setFistName(entity.getFirstName());
        characterDTO.setLastName(entity.getLastName());
        characterDTO.setPictureURL(entity.getPicture());
        characterDTO.setAge(entity.getAge());
        return characterDTO;
    }

    @Override
    public Character updateEntity(Character entity, CharacterDTO dto) {
        entity.setFirstName(dto.getFistName());
        entity.setLastName(dto.getLastName());
        entity.setPicture(dto.getPictureURL());
        entity.setAge(dto.getAge());
        return entity;
    }

}
