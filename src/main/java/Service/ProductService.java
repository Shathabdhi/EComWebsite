package Service;

import DTO.FakeStoreProductResponseDTO;
import entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productID);
    Product createProduct(Product product);
    Product uodateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productID);

}
