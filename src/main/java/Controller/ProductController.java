package Controller;

import DTO.FakeStoreProductResponseDTO;
import Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService; //feild injection

    @GetMapping("/product")
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
        //cant return the product itself so we should return DTO
        return null;
    }
}
