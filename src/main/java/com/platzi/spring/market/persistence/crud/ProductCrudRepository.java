package com.platzi.spring.market.persistence.crud;

import com.platzi.spring.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Product> findByIdCategoryOrderByName(int idCategory);
    Optional<List<Product>> findByStockLessThanAndState(int stock, boolean state);
}
