package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Facility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, Integer> {
}
