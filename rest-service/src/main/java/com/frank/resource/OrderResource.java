package com.frank.resource;

import com.frank.model.Order;
import com.frank.model.OrderResponse;
import com.frank.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class OrderResource {
    private static final String ORDER_URI = "/order";

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = ORDER_URI+"/submit", method = POST)
    public OrderResponse submitOrder(@RequestBody Order order) {
        return orderService.submit(order);
    }

    @RequestMapping(value = ORDER_URI+"/view", method = GET)
    public Order viewOrder(@RequestParam(value="id") String id) {
        return orderService.view(id);
    }
}
