package com.platzi.spring.market.persistence;

import com.platzi.spring.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.spring.market.domain.PurchaseDTO;
import com.platzi.spring.market.domain.repository.PurchaseDTORepository;
import com.platzi.spring.market.persistence.entity.Purchase;
import com.platzi.spring.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseDTORepository {

    @Autowired
    private PurchaseCrudRepository repository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<PurchaseDTO> getPurchases() {
        return mapper.toPurchasesDTO((List<Purchase>) repository.findAll());
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClient(String clientId) {
        return repository.findByIdClient(clientId)
                .map(purchases -> mapper.toPurchasesDTO(purchases));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchase = mapper.toPurchase(purchaseDTO);
        purchase.getProducts().forEach(prod -> prod.setPurchase(purchase));
        return mapper.toPurchaseDTO(repository.save(purchase));
    }
}
