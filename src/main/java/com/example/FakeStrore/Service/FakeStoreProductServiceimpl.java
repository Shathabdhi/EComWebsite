package com.example.FakeStrore.Service;

import com.example.FakeStrore.Client.FakeStoreClient;
import com.example.FakeStrore.DTO.fakeStroreDTOs.FakeStoreProductResponseDTO;
import com.example.FakeStrore.entity.Product;
import com.example.FakeStrore.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("fakeStoreProductService")
public class FakeStoreProductServiceimpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
         List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
         return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getProduct(int productID) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductsById(productID);
        if (fakeStoreProductResponseDTO == null){
            throw  new ProductNotFoundException("Product not found with id : "+ productID);
        }
        return fakeStoreProductResponseDTO;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product uodateProduct(Product updatedProduct, int productId) {
        return null;
    }


    public boolean deleteProduct(int productID) {
        return false;
    }
}
