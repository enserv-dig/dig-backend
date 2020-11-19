package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Pipeline;
import com.enservsolutions.dig.entity.Upload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository extends CrudRepository<Upload, Integer> {
}
