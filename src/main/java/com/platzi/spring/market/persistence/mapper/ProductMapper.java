package com.platzi.spring.market.persistence.mapper;

import com.platzi.spring.market.domain.ProductDTO;
import com.platzi.spring.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salesPrice", target = "price"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "category", target = "category")
    })
    ProductDTO toProductDTO(Product product);
    List<ProductDTO> toProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(ProductDTO product);
}
