package com.fengziboboy.demo.data;

import com.fengziboboy.demo.Order;

public interface OrderRepository {
    Order save(Order order);
}
