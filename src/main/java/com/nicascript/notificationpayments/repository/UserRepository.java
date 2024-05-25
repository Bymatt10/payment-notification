package com.nicascript.notificationpayments.repository;

import com.nicascript.notificationpayments.dto.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
