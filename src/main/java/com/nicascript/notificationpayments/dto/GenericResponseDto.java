package com.nicascript.notificationpayments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseDto<T> implements Serializable {

    private int code;
    private String message;
    private T data;

}
