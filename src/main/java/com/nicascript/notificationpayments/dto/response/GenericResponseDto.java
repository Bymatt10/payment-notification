package com.nicascript.notificationpayments.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseDto<T> {

    private int code;
    private String message;
    private T data;

}
