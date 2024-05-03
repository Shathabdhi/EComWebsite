package com.example.FakeStrore.Controller;

import com.example.FakeStrore.DTO.fakeStroreDTOs.CategoryResponseDTO;
import com.example.FakeStrore.DTO.fakeStroreDTOs.CreateCategoryRequestDTO;
import com.example.FakeStrore.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>>getAllCategories(){

    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO>getCategyById(@PathVariable("id")UUID categoryId){

    }
    @PostMapping
    public ResponseEntity<CategoryResponseDTO>createCategory(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){

    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") UUID categoryId,@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delteCategory (@PathVariable("id")UUID categoryId){

    }
}
