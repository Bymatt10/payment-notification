package com.nicascript.notificationpayments.services;

import com.nicascript.notificationpayments.dto.entity.CategoryEntity;
import com.nicascript.notificationpayments.dto.request.CategoryUpdateDto;
import com.nicascript.notificationpayments.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<CategoryEntity> categoryList(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Cacheable(value = "category:find", key = "#uuid")
    public CategoryEntity findByUuid(UUID uuid) {
        var findUuid = categoryRepository.findById(uuid);
        if (findUuid.isPresent()) {
            return findUuid.get();
        }
        throw new EntityNotFoundException("Category with id: " + uuid + " not found");
    }

    public CategoryEntity updateByUuid(UUID uuid, CategoryUpdateDto categoryUpdateDto) {
        var categoryDto = categoryRepository.findById(uuid);
        if (categoryDto.isEmpty()) {
            throw new EntityNotFoundException("Category with id: " + uuid + " not found");
        }
        categoryDto.get().setName(categoryUpdateDto.getName());
        var result = categoryRepository.save(categoryDto.get());
        return result;
    }

    public CategoryEntity deleteByUuid(UUID uuid) {
        var findEntity = categoryRepository.findById(uuid);
        if (findEntity.isEmpty()) {
            throw new EntityNotFoundException("Category with id: " + uuid + " not found");
        }
        categoryRepository.deleteById(uuid);
        return findEntity.get();
    }
}