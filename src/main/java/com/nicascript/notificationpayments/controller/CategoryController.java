package com.nicascript.notificationpayments.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicascript.notificationpayments.dto.entity.CategoryEntity;
import com.nicascript.notificationpayments.dto.request.CategoryCreateDto;
import com.nicascript.notificationpayments.dto.request.CategoryUpdateDto;
import com.nicascript.notificationpayments.services.Impl.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

  private final ObjectMapper objectMapper;

  private final CategoryServices services;

  @Autowired
  public CategoryController(CategoryServices services, ObjectMapper objectMapper) {
    this.services = services;
    this.objectMapper = objectMapper;
  }

  @GetMapping("/listCategory")
  public ResponseEntity<Object> categoryList(
      @RequestParam(name = "page", defaultValue = "0") Integer page,
      @RequestParam(name = "page", defaultValue = "0") Integer size) {
    Pageable pageable = PageRequest.of(page, size);
    var response = services.categoryList(pageable);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/category")
  public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryCreateDto category) {
    var response = services.saveCategory(objectMapper.convertValue(category, CategoryEntity.class));
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/list/{uuid}")
  public ResponseEntity<CategoryEntity> findByUuid(@PathVariable UUID uuid) {
    var response = services.findByUuid(uuid);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/category/{uuid}")
  public ResponseEntity<CategoryEntity> updateByUuid(
      @PathVariable UUID uuid, @RequestBody CategoryUpdateDto categoryUpdateDto) {
    var response = services.updateByUuid(uuid, categoryUpdateDto);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/category/{uuid}")
  public ResponseEntity<CategoryEntity> deleteByUuid(@PathVariable UUID uuid) {
    var response = services.deleteByUuid(uuid);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
