package org.nye.interfaces;

import org.nye.models.Card;

public interface PaymentMethod {
    boolean processPayment(int amount, Card card);
}
