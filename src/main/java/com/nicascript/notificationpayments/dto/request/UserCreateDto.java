package com.nicascript.notificationpayments.dto.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;

@Data
public class UserCreateDto {
    private String name;

    private String password;
}
