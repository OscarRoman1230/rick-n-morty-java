package com.api.crud.services;

import com.api.crud.models.CharacterModel;
import com.api.crud.repositories.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    ICharacterRepository characterRepository;

    public ArrayList<CharacterModel> getAllCharacters() {
        return (ArrayList<CharacterModel>) characterRepository.findAll();
    }

    public Optional<CharacterModel> getCharacterById(Long id) {
        return characterRepository.findById(id);
    }

    public CharacterModel addCharacter(CharacterModel character) {
        return characterRepository.save(character);
    }

    public CharacterModel updateCharacter(CharacterModel request, Long id) {
        CharacterModel character = characterRepository.findById(id).get();

        character.setName(request.getName());
        character.setStatus(request.getStatus());
        character.setSpecies(request.getSpecies());
        character.setType(request.getType());
        character.setGender(request.getGender());
        character.setOrigin(request.getOrigin());
        character.setLocation(request.getLocation());
        character.setImage(request.getImage());
        character.setUrl(request.getUrl());
        character.setCreated(request.getCreated());

        return character;
    }

    public Boolean deleteCharacter(Long id) {
        try {
            characterRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
