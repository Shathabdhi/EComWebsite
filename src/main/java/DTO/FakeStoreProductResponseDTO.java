package DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String sescription;
    private String category;
    private String image;
    private FakeStoreProductRatingDTO rating;
}




