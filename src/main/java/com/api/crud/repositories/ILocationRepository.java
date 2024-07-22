package com.api.crud.repositories;

import com.api.crud.models.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<LocationModel, Long> {
}
