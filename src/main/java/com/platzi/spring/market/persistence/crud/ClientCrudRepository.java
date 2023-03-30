package com.platzi.spring.market.persistence.crud;

import com.platzi.spring.market.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, String> {
}
