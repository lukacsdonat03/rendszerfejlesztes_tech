package org.nye.services;

import org.nye.models.Card;
import org.nye.models.Order;

public class OrderServiceImpl implements org.nye.interfaces.OrderService {
    private PaymentService paymentService;

    public OrderServiceImpl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public Order createOrder() {
        return null;
    }

    @Override
    public boolean checkoutOrder(Order order) {
        double totalPrice = order.getTotalPrice();
        Card card = new Card("1234567890123456", "12/25", "John Doe");
        return paymentService.processPayment((int) Math.round(totalPrice), card);
    }
}
