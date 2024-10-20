package org.nye.models;

public class Product{

    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private ProductStatus status;

    public Product() {
    }

    public Product(long id, String name, String description, double price, int stock,ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock == 0){
            this.status = ProductStatus.INACTIVE;
        }
        this.stock = stock;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getStatusName(){
        if(this.status == ProductStatus.INACTIVE){
            return "Inactive";
        }else{
            return "Active";
        }
    }

    //Bruttó ár, ha lennének termék variációk, nagyobb szerepe lenne
    public double getSellingPrice(){
        return this.price + (this.price * 0.27);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{")
                .append("\n  id=").append(id)
                .append(",\n  name='").append(name).append('\'')
                .append(",\n  description='").append(description).append('\'')
                .append(",\n  price=").append(price)
                .append(",\n  stock=").append(stock)
                .append(",\n status=").append(this.getStatusName())
                .append("\n}");

        return sb.toString();
    }

}
