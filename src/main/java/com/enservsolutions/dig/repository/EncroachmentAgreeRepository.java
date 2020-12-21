package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.EncroachmentAgree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncroachmentAgreeRepository extends CrudRepository<EncroachmentAgree, Integer> {
}
