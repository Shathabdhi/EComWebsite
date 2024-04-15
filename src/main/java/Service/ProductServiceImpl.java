package Service;

import DTO.FakeStoreProductResponseDTO;
import entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return null;
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
