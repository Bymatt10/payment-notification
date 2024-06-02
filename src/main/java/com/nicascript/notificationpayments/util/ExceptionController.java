package com.nicascript.notificationpayments.util;

import com.nicascript.notificationpayments.dto.GenericResponseDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<Object> handleError(HttpServletRequest request) {
        var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        var standardResponse = new GenericResponseDto<>();

        var statusCode = Integer.parseInt(status.toString());
        standardResponse.setCode(statusCode);
        standardResponse.setMessage(HttpStatus.valueOf(statusCode).getReasonPhrase());
        return ResponseEntity.status(HttpStatus.valueOf(statusCode)).body(standardResponse);
    }
}
