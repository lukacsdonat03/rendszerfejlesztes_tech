package org.nye.interfaces;

import org.nye.models.Order;

public interface OrderService {
    Order createOrder();
    boolean checkoutOrder(Order order);

}
