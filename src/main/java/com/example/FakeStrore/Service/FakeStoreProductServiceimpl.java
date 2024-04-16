package com.example.FakeStrore.Service;

import com.example.FakeStrore.Client.FakeStoreClient;
import com.example.FakeStrore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStrore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeStoreProductServiceimpl implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
         List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
         return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productID) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductsById(productID);
        return fakeStoreProductResponseDTO;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product uodateProduct(Product updatedProduct, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productID) {
        return false;
    }
}
