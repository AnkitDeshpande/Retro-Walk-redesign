package com.retrowalk.controller;

import com.retrowalk.entities.User;
import com.retrowalk.entities.WebOrder;
import com.retrowalk.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to handle requests to create, update and view orders.
 */
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    /**
     * The Order Service.
     */
    private final OrderService orderService;

    /**
     * Endpoint to get all orders for a specific user.
     *
     * @param user The user provided by spring security context.
     * @return The list of orders the user had made.
     */
    @GetMapping
    public List<WebOrder> getOrders(@AuthenticationPrincipal User user) {
        return orderService.getOrders(user);
    }

}
