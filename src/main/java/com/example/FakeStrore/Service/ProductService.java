package com.example.FakeStrore.Service;

import com.example.FakeStrore.DTO.CreateProductRequestDTO;
import com.example.FakeStrore.DTO.ProductResponseDTO;
import com.example.FakeStrore.entity.Product;
import com.example.FakeStrore.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productID) throws ProductNotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProduct(String productName);
    List<Product> getProduct(double minPrice, double maxPrice);

}