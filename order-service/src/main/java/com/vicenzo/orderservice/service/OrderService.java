package com.vicenzo.orderservice.service;

import com.vicenzo.orderservice.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
