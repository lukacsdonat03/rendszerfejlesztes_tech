import org.junit.jupiter.api.Test;
import org.nye.models.*;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderTest {

    @Test
    void testGetTotalPriceWithNoProductsOrShipping() {

        Order order = new Order(1, Collections.emptyList(), "Pending", null);


        double totalPrice = order.getTotalPrice();


        assertEquals(0.0, totalPrice, "Total price should be 0 when there are no products or shipping.");
    }

    @Test
    void testGetTotalPrice() {
        Product product = new Product(1,"Test Product", "Test", 20.0,4,ProductStatus.ACTIVE);
        OrderedProduct orderedProduct = new OrderedProduct(1, product, 3);

        double totalPrice = orderedProduct.getTotalPrice();

        assertEquals(60.0, totalPrice, "Total price should be product price multiplied by quantity.");
    }

}