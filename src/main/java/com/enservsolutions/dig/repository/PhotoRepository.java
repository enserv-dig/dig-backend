package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    Optional<Photo> findByName(String name);
}
