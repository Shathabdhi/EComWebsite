package com.example.FakeStrore.Mapper;

import com.example.FakeStrore.DTO.CreateProductRequestDTO;
import com.example.FakeStrore.DTO.ProductResponseDTO;
import com.example.FakeStrore.entity.Product;

public class ProductEntityDTOMapper {

    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setTitle(product.getTitle());
        responseDTO.setPrice(product.getPrice());
//        responseDTO.setCategory(product.getCategory());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setRating(product.getRating());
        responseDTO.setCategory(product.getCategory().getName());
        return responseDTO;
    }

    public static Product convertCreateProductRequestDTOtoProduct(CreateProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setPrice(productRequestDTO.getPrice());
//        product.setCategory(productRequestDTO.getCategory());
        product.setDescription(productRequestDTO.getDescription());
        product.setImageURL(productRequestDTO.getImageURL());
        product.setRating(0);
//        product.setCategory(product.getCategory().getName());
        return product;

    }
}
