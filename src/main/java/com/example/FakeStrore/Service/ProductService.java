package com.example.FakeStrore.Service;

import com.example.FakeStrore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStrore.entity.Product;
import com.example.FakeStrore.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productID) throws ProductNotFoundException;
    Product createProduct(Product product);
    Product uodateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productID);

}
