package com.example.FakeStrore.Controller;

import com.example.FakeStrore.DTO.CreateProductRequestDTO;
import com.example.FakeStrore.DTO.ProductResponseDTO;
import com.example.FakeStrore.Mapper.ProductEntityDTOMapper;
import com.example.FakeStrore.Service.ProductService;
import com.example.FakeStrore.entity.Product;
import com.example.FakeStrore.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService; //feild injection

    @GetMapping()
    public ResponseEntity <List<ProductResponseDTO>>getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts();
        //cant return the product itself so we should return DTO
        return ResponseEntity.ok(products);
    }
    /*
    Code from Service layer
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProducts = productRepository.findAll();//returns list of all products
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for (Product product : savedProducts){
            productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDTOs;
    }
     */
    @GetMapping("/{id}")
    public ResponseEntity getproductById(@PathVariable("id") UUID id){
        if (id == null){
            throw new ProductNotFoundException("Input is not correct");
        }
        return ResponseEntity.ok(productService.getProduct(id));
        //return ResponseEntity.ok(product);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO productRequestDTO){

        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable ("id") UUID id, @RequestBody CreateProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO,id));
    }

    //used for demo of controller advice
    /*
    @GetMapping("/productexception")
    public ResponseEntity getProductException(){
        throw new RandomException("Exception from product");
    }
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable ("id") UUID id){
        return ResponseEntity.ok(
                productService.deleteProduct(id)
        );
    }
    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDTO> getProductByProductName(@PathVariable ("productName") String productName){
        return ResponseEntity.ok(
                productService.getProduct(productName)
        );
    }
    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductByPriceRange(@PathVariable ("min") double minPrice,@PathVariable ("max") double maxPrice){
        return ResponseEntity.ok(
                productService.getProduct(minPrice,maxPrice)
        );
    }

}
