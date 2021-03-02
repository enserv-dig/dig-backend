package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Pipeline;
import com.enservsolutions.dig.entity.Role;
import com.enservsolutions.dig.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String s);

}
