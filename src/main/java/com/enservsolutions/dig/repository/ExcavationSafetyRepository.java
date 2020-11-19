package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Dig;
import com.enservsolutions.dig.entity.ExcavationSafety;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcavationSafetyRepository extends CrudRepository<ExcavationSafety, Integer> {
}
