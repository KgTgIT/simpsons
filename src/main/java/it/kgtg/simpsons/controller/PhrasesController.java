package it.kgtg.simpsons.controller;

import it.kgtg.simpsons.dto.CreatePhraseDTO;
import it.kgtg.simpsons.dto.PhraseDTO;
import it.kgtg.simpsons.service.PhrasesService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@Validated
@RestController
@RequestMapping("simpsons/v1/characters/{characterId}/phrases")
public class PhrasesController {

    private final PhrasesService phrasesService;

    public PhrasesController(PhrasesService phrasesService) {
        this.phrasesService = phrasesService;
    }

    @GetMapping("/{phraseId}")
    public ResponseEntity<PhraseDTO> getPhrase(@Valid
                                               @Pattern(regexp = "\\w{24}", message = "Phrase ID must be a valid Mongo identifier")
                                               @PathVariable String phraseId) {
        PhraseDTO phraseDTO = phrasesService.getPhrase(phraseId);
        return ResponseEntity.ok(phraseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<PhraseDTO>> getPhrases(@PathVariable String characterId) {
        List<PhraseDTO> phraseDTOs = phrasesService.getCharacterPhrases(characterId);
        return ResponseEntity.ok(phraseDTOs);
    }

    @PostMapping()
    public ResponseEntity<PhraseDTO> createPhrase(@Valid
                                                  @RequestBody CreatePhraseDTO createPhraseDTO) {
        PhraseDTO phraseDTO = phrasesService.createPhrase(createPhraseDTO);
        URI locationHeader = getNewPhraseLocationHeader(createPhraseDTO.getCharacterId(), phraseDTO.getId());
        return ResponseEntity.created(locationHeader)
                             .body(phraseDTO);
    }

    private URI getNewPhraseLocationHeader(String characterId, String phraseId) {
        ResponseEntity<PhraseDTO> getPhrase = on(PhrasesController.class).getPhrase(phraseId);
        return fromMethodCall(getPhrase)
            .buildAndExpand(characterId, phraseId)
            .encode()
            .toUri();
    }

    @DeleteMapping("/{phraseId}")
    public ResponseEntity<String> removePhrase(@Valid
                                               @Pattern(regexp = "\\w{24}", message = "Phrase ID must be a valid Mongo identifier")
                                               @PathVariable String phraseId) {
        phrasesService.removePhrase(phraseId);
        return ResponseEntity.ok("Deleted phrase " + phraseId);
    }

}
