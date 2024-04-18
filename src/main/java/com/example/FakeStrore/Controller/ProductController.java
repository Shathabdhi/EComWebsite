package com.example.FakeStrore.Controller;

import com.example.FakeStrore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStrore.Service.ProductService;
import com.example.FakeStrore.entity.Product;
import com.example.FakeStrore.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService; //feild injection

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
        //cant return the product itself so we should return DTO
        return ResponseEntity.ok(products);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity getproductById(@PathVariable("id") int id){
        if (id < 1){
            throw new ProductNotFoundException("Input is not correct");
        }
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
