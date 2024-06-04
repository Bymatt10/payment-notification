package com.nicascript.notificationpayments.repository;

import com.nicascript.notificationpayments.dto.entity.ListWhite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WhiteListRepository extends JpaRepository<UUID, ListWhite> {
}
