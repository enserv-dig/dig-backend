package com.enservsolutions.dig.repository;

import com.enservsolutions.dig.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    Client getClientByClientName(String name);
}
