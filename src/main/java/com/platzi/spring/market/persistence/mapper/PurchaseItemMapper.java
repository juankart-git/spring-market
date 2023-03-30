package com.platzi.spring.market.persistence.mapper;

import com.platzi.spring.market.domain.PruchaseItemDTO;
import com.platzi.spring.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "state", target = "active")
    })
    PruchaseItemDTO toPruchaseItemDTO(PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "id.idPurchase", ignore = true),
        @Mapping(target = "purchase", ignore = true),
        @Mapping(target = "product", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PruchaseItemDTO item);
}
