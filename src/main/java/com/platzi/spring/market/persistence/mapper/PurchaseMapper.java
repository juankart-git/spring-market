package com.platzi.spring.market.persistence.mapper;

import com.platzi.spring.market.domain.PurchaseDTO;
import com.platzi.spring.market.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "products", target = "items")
    })
    PurchaseDTO toPurchaseDTO(Purchase purchase);
    List<PurchaseDTO> toPurchasesDTO(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(PurchaseDTO purchaseDTO);
}
