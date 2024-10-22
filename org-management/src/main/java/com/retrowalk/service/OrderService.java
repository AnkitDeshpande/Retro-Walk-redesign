package com.retrowalk.service;

import com.retrowalk.entities.User;
import com.retrowalk.entities.WebOrder;

import java.util.List;

public interface OrderService {

    public List<WebOrder> getOrders(User user);
}
