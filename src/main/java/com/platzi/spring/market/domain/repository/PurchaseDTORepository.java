package com.platzi.spring.market.domain.repository;

import com.platzi.spring.market.domain.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseDTORepository {

    List<PurchaseDTO> getPurchases();
    Optional<List<PurchaseDTO>> getByClient(String clientId);
    PurchaseDTO save(PurchaseDTO purchase);

}
