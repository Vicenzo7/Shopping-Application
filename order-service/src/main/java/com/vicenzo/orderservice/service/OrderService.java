package com.vicenzo.orderservice.service;

import com.vicenzo.orderservice.dto.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
