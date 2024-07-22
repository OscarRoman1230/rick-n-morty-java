package com.api.crud.repositories;

import com.api.crud.models.CharacterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterRepository extends JpaRepository<CharacterModel, Long> {
}
