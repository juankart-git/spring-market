package com.platzi.spring.market.domain.repository;

import com.platzi.spring.market.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductDTORepository {

    List<ProductDTO> getProducts();
    Optional<List<ProductDTO>> getByCategory(int categoryId);
    Optional<List<ProductDTO>> getLessProducts(int amount);
    Optional<ProductDTO> getProduct(int productId);
    ProductDTO saveProduct(ProductDTO product);
    void deleteProduct(int productId);

}
