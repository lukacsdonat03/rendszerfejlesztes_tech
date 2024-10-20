package org.nye.services;

import org.nye.models.ShippingMethod;

import java.util.Arrays;
import java.util.List;

public class ShippingServiceImpl implements org.nye.interfaces.ShippingService {
    @Override
    public List<ShippingMethod> getAvailableShippingMethods() {
        return Arrays.asList(
                new ShippingMethod(1L, "Standard Shipping", 5.00, 5),
                new ShippingMethod(2L, "Express Shipping", 10.00, 2),
                new ShippingMethod(3L, "Next-Day Shipping", 20.00, 1)
        );
    }

    @Override
    public ShippingMethod getShippingMethodById(Long id) {
        return getAvailableShippingMethods().stream()
                .filter(method -> method.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
