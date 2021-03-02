package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends CrudRepository<Company, Integer> {
}
