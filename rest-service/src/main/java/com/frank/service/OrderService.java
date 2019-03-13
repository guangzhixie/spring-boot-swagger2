package com.frank.service;

import com.frank.model.Order;
import com.frank.model.OrderResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    private Map<String, Order> orderCache = new HashMap<>();

    public OrderResponse submit(Order order) {
        String id = order.getId();
        BigDecimal amount = order.getAmount();
        if (!StringUtils.isEmpty(id) && amount.signum() <= 0) {
            return new OrderResponse("6001", "INVALID_ORDER_AMOUNT");
        }
        orderCache.put(id, order);
        return new OrderResponse("6000", "SUCCESS");
    }


    public Order view(String id) {
        return orderCache.get(id);
    }
}
