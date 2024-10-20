package org.nye.interfaces;

import org.nye.models.ShippingMethod;

import java.util.List;

public interface ShippingService {
    List<ShippingMethod> getAvailableShippingMethods();
    ShippingMethod getShippingMethodById(Long id);
}