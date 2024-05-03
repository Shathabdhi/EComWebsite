package com.example.FakeStrore.DTO;

import java.util.List;
import java.util.UUID;

public class CategoryResponseDTO {
    private UUID categortId;
    private String categoryName;
    private List<ProductResponseDTO> products;
}
