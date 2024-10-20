package org.nye.models;

public class ShippingMethod {
    private long id;
    private String name;
    private double cost;
    private int estimatedDeliveryDays;

    public ShippingMethod(Long id, String name, double cost, int estimatedDeliveryDays) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.estimatedDeliveryDays = estimatedDeliveryDays;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public int getEstimatedDeliveryDays() { return estimatedDeliveryDays; }
    public void setEstimatedDeliveryDays(int estimatedDeliveryDays) { this.estimatedDeliveryDays = estimatedDeliveryDays; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("ShippingMethod{")
                .append("\n  id=").append(id)
                .append(",\n  name='").append(name).append('\'')
                .append(",\n  cost=").append(cost)
                .append(",\n  estimatedDeliveryDays=").append(estimatedDeliveryDays)
                .append("\n}").toString();
    }
}
