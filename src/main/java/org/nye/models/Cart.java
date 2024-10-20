package org.nye.models;

import java.util.List;

public class Cart {

    private long id;
    private List<CartProduct> products;

    public Cart() {
    }

    public Cart(long id, List<CartProduct> products) {
        this.id = id;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public double getTotalPrice(){
        double result = 0;

        for(CartProduct prod: this.products){
            result += prod.getProduct().getSellingPrice() * prod.getQuantity();
        }
        
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart{")
                .append("\n  id=").append(id)
                .append(",\n  products=").append(products)
                .append(",\n total price=").append(this.getTotalPrice())
                .append("\n}");

        return sb.toString();
    }
}
