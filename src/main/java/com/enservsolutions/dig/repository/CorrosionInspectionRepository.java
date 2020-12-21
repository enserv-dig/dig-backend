package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.CorrosionInspection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrosionInspectionRepository extends CrudRepository<CorrosionInspection, Integer> {
}
