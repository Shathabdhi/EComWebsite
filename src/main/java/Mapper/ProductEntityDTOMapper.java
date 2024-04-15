package Mapper;

import DTO.ProductResponseDTO;
import entity.Product;

public class ProductEntityDTOMapper {

    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setRating(product.getRating());
        return responseDTO;
    }

}
