package com.platzi.spring.market.web.controller;

import com.platzi.spring.market.domain.PurchaseDTO;
import com.platzi.spring.market.domain.service.PurchaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseServices service;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getPurchases(){
        return ResponseEntity.ok(service.getPurchases());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<PurchaseDTO>> getProduct(@PathVariable("id") String id){
        return service.getPurchaseByClient(id)
                .map(purchase -> ResponseEntity.ok(purchase))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchase){
        return new ResponseEntity<>(service.savePurchase(purchase), HttpStatus.CREATED);
    }


}
