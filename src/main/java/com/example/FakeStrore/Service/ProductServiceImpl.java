package com.example.FakeStrore.Service;

import com.example.FakeStrore.DTO.CreateProductRequestDTO;
import com.example.FakeStrore.DTO.ProductResponseDTO;
import com.example.FakeStrore.Mapper.ProductEntityDTOMapper;
import com.example.FakeStrore.Repository.CategoryRepository;
import com.example.FakeStrore.Repository.ProductRepository;
import com.example.FakeStrore.entity.Category;
import com.example.FakeStrore.entity.Product;
import com.example.FakeStrore.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProducts = productRepository.findAll();//returns list of all products
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for (Product product : savedProducts){
            productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productID) throws ProductNotFoundException {
        /*
        //basic code to implement null check
        Product savedProduct = productRepository.findById(productID).get();
        if (savedProduct == null){
            throw new ProductNotFoundException("Product not fount for "+ productID);
        }
        return savedProduct;

         */
       Product product =  productRepository.findById(productID).orElseThrow(
                () -> new ProductNotFoundException("Product not fount for "+ productID)
        );
       return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.convertCreateProductRequestDTOtoProduct(productRequestDTO);
        Category savedCategory = categoryRepository.findById(productRequestDTO.getCategoryID()).orElseThrow(
                () -> new ProductNotFoundException("Category not fount for id "+ productRequestDTO.getCategoryID()));
        product.setCategory(savedCategory);
        product = productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    //cant update category and rating for a product
    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID productId) {
        Product savedProduct =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not fount for "+ productId)
        );
        savedProduct.setTitle(createProductRequestDTO.getTitle());
        savedProduct.setImageURL(createProductRequestDTO.getImageURL());
        savedProduct.setPrice(createProductRequestDTO.getPrice());
        savedProduct.setDescription(createProductRequestDTO.getDescription());
        savedProduct = productRepository.save(savedProduct);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }


    @Override
    public boolean deleteProduct(UUID productID) {
        productRepository.deleteById(productID);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(
                productRepository.findProductByTitle(productName)
        );
    }

    //TODO : convert product list to product response dto list
    @Override
    public List<Product> getProduct(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }


}
