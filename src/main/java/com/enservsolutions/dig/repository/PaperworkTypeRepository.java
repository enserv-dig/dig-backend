package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.PaperworkType;
import org.springframework.data.repository.CrudRepository;

public interface PaperworkTypeRepository extends CrudRepository<PaperworkType, Integer> {
    public PaperworkType getPaperworkTypeByPaperworkTypeTitle(String title);
}
