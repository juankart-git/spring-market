package com.platzi.spring.market.domain.service;

import com.platzi.spring.market.domain.dto.PurchaseDTO;
import com.platzi.spring.market.domain.repository.PurchaseDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServices {

    @Autowired
    private PurchaseDTORepository repository;

    public List<PurchaseDTO> getPurchases(){
        return repository.getPurchases();
    }

    public Optional<List<PurchaseDTO>> getPurchaseByClient(String clientId){
        return repository.getByClient(clientId);
    }

    public PurchaseDTO savePurchase(PurchaseDTO purchase){
        return repository.save(purchase);
    }

}
