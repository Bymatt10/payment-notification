package com.nicascript.notificationpayments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nicascript.notificationpayments.dto.entity.PaymentEntity;
import com.nicascript.notificationpayments.dto.request.PaymentCreateDto;
import com.nicascript.notificationpayments.dto.request.PaymentReportDto;
import com.nicascript.notificationpayments.services.Impl.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
@RestController("api/v1/payment")
public class PaymentController {
    private final PaymentServices services;

    @Autowired
    public PaymentController(PaymentServices services) {
        this.services = services;
    }

    @GetMapping("/payment/list")
    public ResponseEntity<Object> getAllPayment() {
        var response = services.getAllPayment();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentEntity> createPayment(PaymentCreateDto paymentCreateDto) {
        var response = services.createPayment(new PaymentEntity(paymentCreateDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/payment/{uuid}")
    public ResponseEntity<PaymentEntity> paymentByUuid(@PathVariable UUID uuid) {
        var response = services.paymentByUuid(uuid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/payment/details")
    public ResponseEntity<List<PaymentReportDto>> findPaymentCategoryDetails() throws JsonProcessingException {
        var response = services.getPaymentCategoryDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
