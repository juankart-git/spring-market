package com.platzi.spring.market.persistence;

import com.platzi.spring.market.domain.ProductDTO;
import com.platzi.spring.market.domain.repository.ProductDTORepository;
import com.platzi.spring.market.persistence.crud.ProductCrudRepository;
import com.platzi.spring.market.persistence.entity.Product;
import com.platzi.spring.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDTORepository {

    @Autowired
    private ProductCrudRepository repository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = (List<Product>) repository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(int idCategory){
        List<Product> products = repository.findByIdCategoryOrderByName(idCategory);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDTO>> getLessProducts(int amount){
        Optional<List<Product>> products = repository.findByStockLessThanAndState(amount, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<ProductDTO> getProduct(int id){
        return repository.findById(id).map(prod -> mapper.toProductDTO(prod));
    }

    @Override
    public ProductDTO saveProduct(ProductDTO product) {
        return mapper.toProductDTO(repository.save(mapper.toProduct(product)));
    }

    @Override
    public void deleteProduct(int id){
        repository.deleteById(id);
    }
}
