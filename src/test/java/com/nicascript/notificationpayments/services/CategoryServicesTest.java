package com.nicascript.notificationpayments.services;

import com.nicascript.notificationpayments.dto.entity.CategoryEntity;
import com.nicascript.notificationpayments.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CategoryServicesTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServices categoryServices;

    private UUID uuid = UUID.randomUUID();
    @BeforeEach
    void setUp() {
    }

    @Test
    void findByUuidSuccess() {
        Mockito.when(categoryRepository.findById(any())).thenReturn(generateCategoryEntity());
        var result = categoryServices.findByUuid(uuid);
        assertSame(generateCategoryEntity().get().getUuid(), result.getUuid());
    }

    @Test
    void findByUuidError() {
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> categoryServices.findByUuid(uuid));
    }

    @Test
    void deleteByUuid() {
    }

    private Optional<CategoryEntity> generateCategoryEntity(){
        var categoryEntity = new CategoryEntity();
        categoryEntity.setName("Test");
        categoryEntity.setUuid(uuid);
        return Optional.of(categoryEntity);
    }
}