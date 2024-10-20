package org.nye.services;

import org.nye.interfaces.PaymentMethod;
import org.nye.models.Card;

public class PaymentService implements PaymentMethod {

    @Override
    public boolean processPayment(int amount, Card card) {
        if (!card.isValid()) {
            System.out.println("Invalid card details.");
            return false;
        }

        //Sikeres fizetés szimulálása
        System.out.println("Processing payment of $" + amount + " for card " + card.getCardNumber());
        return true;
    }
}
