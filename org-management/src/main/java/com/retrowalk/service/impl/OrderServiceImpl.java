package com.retrowalk.service.impl;

import com.retrowalk.entities.User;
import com.retrowalk.entities.WebOrder;
import com.retrowalk.repository.WebOrderRepository;
import com.retrowalk.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling order actions.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    /**
     * The Web Order DAO.
     */
    private final WebOrderRepository webOrderRepository;

    /**
     * Gets the list of orders for a given user.
     *
     * @param user The user to search for.
     * @return The list of orders.
     */
    @Override
    public List<WebOrder> getOrders(User user) {
        return webOrderRepository.findByUser(user);
    }

}
