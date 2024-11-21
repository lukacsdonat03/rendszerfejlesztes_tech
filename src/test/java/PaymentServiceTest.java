import org.junit.jupiter.api.Test;
import org.nye.models.Card;
import org.nye.services.PaymentService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentServiceTest {
    @Test
    void testProcessPaymentWithValidCard() {

        PaymentService paymentService = new PaymentService();
        Card validCard = new Card("1234567812345678", "12/25", "Teszt Elek");


        boolean result = paymentService.processPayment(100, validCard);


        assertTrue(result, "Payment should be successful with a valid card");
    }

    @Test
    void testProcessPaymentWithInvalidCard() {
        // Arrange
        PaymentService paymentService = new PaymentService();
        Card invalidCard = new Card("123456781234567", "12/25", "Teszt Elek"); //Invalid kartya, kartyaszam csak 15 hosszu

        // Act
        boolean result = paymentService.processPayment(100, invalidCard);

        // Assert
        assertFalse(result, "Payment should fail with an invalid card");
    }
}
