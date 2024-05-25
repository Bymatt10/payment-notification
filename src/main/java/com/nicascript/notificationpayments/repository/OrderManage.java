package com.nicascript.notificationpayments.repository;

import jakarta.persistence.criteria.Order;

public interface OrderManage {
    void placeOrder(Order order);
}
