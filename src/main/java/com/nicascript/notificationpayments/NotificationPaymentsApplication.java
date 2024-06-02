package com.nicascript.notificationpayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NotificationPaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationPaymentsApplication.class, args);
    }

}
