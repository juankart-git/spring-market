package com.platzi.spring.market.domain.service;

import com.platzi.spring.market.domain.ProductDTO;
import com.platzi.spring.market.domain.repository.ProductDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductDTORepository repository;

    public List<ProductDTO> getProducts(){
        return repository.getProducts();
    }

    public Optional<ProductDTO> getProduct(int id){
        return repository.getProduct(id);
    }

    public Optional<List<ProductDTO>> getByCategory(int categoryId){
        return repository.getByCategory(categoryId);
    }

    public ProductDTO saveProduct(ProductDTO product){
        return repository.saveProduct(product);
    }

    public boolean deleteProduct(int id){
        return getProduct(id).map(prod -> {
            repository.deleteProduct(id);
            return true;
        }).orElse(false);
    }
}
