package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.PipeInspection;
import com.enservsolutions.dig.entity.WorkPermit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PipeInspectionRepository extends CrudRepository<PipeInspection, Integer> {
}
