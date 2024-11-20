package org.nye.models;

import java.util.List;

public class Order {
    private long id;
    private List<OrderedProduct> orderedProducts;
    private String status;
    private ShippingMethod shippingMethod;
    private Coupon coupon;

    public Order() {
    }

    public Order(long id, List<OrderedProduct> orderedProducts, String status,ShippingMethod shippingMethod) {
        this.id = id;
        this.orderedProducts = orderedProducts;
        this.status = status;
        this.shippingMethod = shippingMethod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public double getTotalPrice() {
        double result = 0;

        double productsTotal = orderedProducts.stream().mapToDouble(OrderedProduct::getTotalPrice).sum();
        double shippingCost = shippingMethod != null ? shippingMethod.getCost() : 0;

        result = productsTotal + shippingCost;

        if(this.coupon != null && this.coupon.isValid()){
            result = this.coupon.applyDiscount(result);
        }

        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{")
                .append("\n  id=").append(id)
                .append(",\n  orderedProducts=").append(orderedProducts)
                .append(",\n  status='").append(status).append('\'')
                .append("\n}");

        return sb.toString();
    }

}
