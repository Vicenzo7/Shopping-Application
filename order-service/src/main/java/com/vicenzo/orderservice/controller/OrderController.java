package com.vicenzo.orderservice.controller;

import com.vicenzo.orderservice.dto.OrderRequest;
import com.vicenzo.orderservice.dto.UniformResponse;
import com.vicenzo.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UniformResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        UniformResponse uniformResponse = new UniformResponse();
        orderService.placeOrder(orderRequest);

        uniformResponse.setResponse("success", "Order placed Successfully");
        return uniformResponse;
    }


}
