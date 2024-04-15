package Service;

import Client.FakeStoreClient;
import DTO.FakeStoreProductRatingDTO;
import DTO.FakeStoreProductResponseDTO;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
         List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
         return fakeStoreProducts;
    }

    @Override
    public Product getProduct(int productID) {
        return null;
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
