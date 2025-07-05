package com.tcs.app.controllers;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private IProductService iProductService;

    ProductController(IProductService iProductService){
       this.iProductService=iProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) throws  Exception{
        ProductDto result = iProductService.getProductById(id);
        return ResponseEntity.ok(result);
    }
}
