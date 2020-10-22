package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.Dig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigRepository extends CrudRepository<Dig, Integer> {
    Dig getDigsByAnomalyId(int aid);
}
