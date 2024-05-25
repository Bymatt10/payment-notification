package com.nicascript.notificationpayments.repository;

import com.nicascript.notificationpayments.dto.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
}
