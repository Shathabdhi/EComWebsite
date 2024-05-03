package com.example.FakeStrore.Service;

import com.example.FakeStrore.DTO.CreateProductRequestDTO;
import com.example.FakeStrore.DTO.fakeStroreDTOs.CategoryResponseDTO;
import com.example.FakeStrore.DTO.fakeStroreDTOs.CreateCategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategory(UUID categoryId);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
     CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO,UUID categoryId);
     boolean deleteCategory (UUID categoryId);
}
