package it.kgtg.simpsons.controller;

import it.kgtg.simpsons.dto.CharacterDTO;
import it.kgtg.simpsons.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RestController
@RequestMapping("simpsons/v1/characters")
public class CharactersController {

    private final CharacterService characterService;

    public CharactersController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterDTO> getCharacter(
        @Valid
        @Pattern(regexp = "\\w{24}", message = "Character ID must be a valid Mongo identifier")
        @PathVariable String characterId) {
        CharacterDTO characterDTO = characterService.getCharacter(characterId);
        return ResponseEntity.ok(characterDTO);
    }

    @GetMapping()
    public ResponseEntity<List<CharacterDTO>> getCharacters() {
        List<CharacterDTO> characterDTOs = characterService.getCharacters();
        return ResponseEntity.ok(characterDTOs);
    }

}
