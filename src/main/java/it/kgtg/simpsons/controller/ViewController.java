package it.kgtg.simpsons.controller;

import it.kgtg.simpsons.dto.CharacterDTO;
import it.kgtg.simpsons.dto.PhraseDTO;
import it.kgtg.simpsons.service.CharacterService;
import it.kgtg.simpsons.service.PhrasesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {

    private final CharacterService characterService;
    private final PhrasesService phrasesService;

    public ViewController(CharacterService characterService, PhrasesService phrasesService) {
        this.characterService = characterService;
        this.phrasesService = phrasesService;
    }

    @GetMapping(path = "/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("characterId", StringUtils.EMPTY);

        List<CharacterDTO> characters = characterService.getCharacters();
        model.addAttribute("characters", characters);
        return "index";
    }

    @GetMapping("/phrases")
    public String phrases(Model model, @RequestParam String characterId) {
        model.addAttribute("phraseId", StringUtils.EMPTY);
        model.addAttribute("characterId", characterId);

        List<PhraseDTO> phrases = phrasesService.getCharacterPhrases(characterId);
        model.addAttribute("phrases", phrases);
        return "phrases";
    }

}
