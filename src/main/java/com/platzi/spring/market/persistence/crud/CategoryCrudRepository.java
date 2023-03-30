package com.platzi.spring.market.persistence.crud;

import com.platzi.spring.market.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
