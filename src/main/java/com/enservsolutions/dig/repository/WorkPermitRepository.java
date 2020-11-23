package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.WorkPermit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPermitRepository extends CrudRepository<WorkPermit, Integer> {
}
