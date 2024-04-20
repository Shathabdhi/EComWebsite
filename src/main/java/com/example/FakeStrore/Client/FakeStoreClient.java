package com.example.FakeStrore.Client;

import com.example.FakeStrore.DTO.FakeStoreCartResponseDTO;
import com.example.FakeStrore.DTO.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
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
        // link =  https://fakestoreapi.com/products/id
        if (userId < 1){
            return null;
        }
        String fakeStoreGetCartForUser = fakeStoreAPIBaseURL.concat(fakeStoreAPICartForUser).concat(String.valueOf(userId));
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartResponse =
                restTemplate.getForEntity(fakeStoreGetCartForUser,FakeStoreCartResponseDTO[].class);
        return List.of(cartResponse.getBody());
    }
    /*
    * https://fakestoreapi.com/carts?userId=1 -- > get cart by user id, and user id is query param


    {
        "id": 1,
            "userId": 1,
            "date": "2020-03-02T00:00:00.000Z",
            "products": [
        {
            "productId": 1,
                "quantity": 4
        },
        {
            "productId": 2,
                "quantity": 1
        },
        {
            "productId": 3,
                "quantity": 6
        }
    ],
        "__v": 0
    },

     */
}
