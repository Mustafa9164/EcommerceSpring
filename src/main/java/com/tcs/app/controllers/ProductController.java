package com.tcs.app.controllers;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) throws Exception {
        ProductDto product = iProductService.createProduct(dto);
        System.out.println("Product saved");
        return ResponseEntity.ok(product);
    }


}
