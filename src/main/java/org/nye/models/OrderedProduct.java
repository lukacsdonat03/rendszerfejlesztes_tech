package org.nye.models;

public class OrderedProduct {
    private long id;
    private Product product;
    private int quantity;

    public OrderedProduct() {
    }

    public OrderedProduct(long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return this.product.getPrice() * this.quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderedProduct{")
                .append("\n  id=").append(id)
                .append(",\n  product=").append(product)
                .append(",\n  quantity=").append(quantity)
                .append("\n}");

        return sb.toString();
    }
}
