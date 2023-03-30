package com.platzi.spring.market.web.controller;

import com.platzi.spring.market.domain.dto.ProductDTO;
import com.platzi.spring.market.domain.service.ProductServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServices service;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code =200, message = "OK")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Get a supermarket products by ID")
    @ApiResponses({
            @ApiResponse( code = 200, message = "OK"),
            @ApiResponse( code = 400, message = "NOT FOUND")
    })
    public ResponseEntity<ProductDTO> getProduct(@ApiParam(value = "Product ID", required = true, example = "1")
                                                     @PathVariable("id") int id){
        return service.getProduct(id)
                .map(prod -> ResponseEntity.ok(prod))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("categoryId") int categoryId){
        return service.getByCategory(categoryId)
                .map(prods -> ResponseEntity.ok(prods))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product){
        return new ResponseEntity<>(service.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        if(service.deleteProduct(id)){
            return (ResponseEntity) ResponseEntity.ok();
        }else{
            return (ResponseEntity) ResponseEntity.notFound();
        }
    }

}
