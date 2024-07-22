package com.api.crud.controllers;

import com.api.crud.models.CharacterModel;
import com.api.crud.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters")
    public ArrayList<CharacterModel> getCharacters() {
        return this.characterService.getAllCharacters();
    }

    @GetMapping("/character/{id}")
    public Optional<CharacterModel> getCharacter(@PathVariable Long id) {
        return this.characterService.getCharacterById(id);
    }

    @PostMapping("/characters")
    public CharacterModel addCharacter(@RequestBody CharacterModel character) {
        return this.characterService.addCharacter(character);
    }

    @PutMapping("/character/{id}")
    public CharacterModel updateCharacter(@PathVariable Long id, @RequestBody CharacterModel character) {
        return this.characterService.updateCharacter(character, id);
    }

    @DeleteMapping("/character/{id}")
    public String deleteCharacter(@PathVariable Long id) {
        boolean ok = this.characterService.deleteCharacter(id);
        if (ok) {
            return "Character is deleted by id " + id;
        }

        return "Could not delete character with id " + id;
    }
}
