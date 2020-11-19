package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Paperwork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperworkRepository extends CrudRepository<Paperwork, Integer> {
    public Paperwork findPaperworkByPaperworkName(String paperworkName);
}
