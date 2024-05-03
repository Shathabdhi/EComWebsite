package com.example.FakeStrore.Client;

import com.example.FakeStrore.DTO.fakeStroreDTOs.FakeStoreCartResponseDTO;
import com.example.FakeStrore.DTO.fakeStroreDTOs.FakeStoreProductResponseDTO;
import com.example.FakeStrore.exception.CartNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient
{
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseURL;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUser;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductUrl = fakeStoreAPIBaseURL.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductUrl,FakeStoreProductResponseDTO[].class);
                return List.of(productResponseList.getBody());
    }
    public FakeStoreProductResponseDTO getProductsById(int id){
       // link =  https://fakestoreapi.com/products/id
        String fakeStoreGetProductURL = fakeStoreAPIBaseURL.concat(fakeStoreAPIProductPath).concat("/"+id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse =
                restTemplate.getForEntity(fakeStoreGetProductURL,FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreCartResponseDTO> getCartByUserId(int userId){
        // link =  https://fakestoreapi.com/carts?userId=1
        if (userId < 1){
            throw new CartNotFoundException("Cart Not found !");
        }
        String fakeStoreGetCartForUser = fakeStoreAPIBaseURL.concat(fakeStoreAPICartForUser + userId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser,FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }
    /*
    * https://fakestoreapi.com/carts?userId=1 -- > get cart by user id, and user id is query param


     */
}
