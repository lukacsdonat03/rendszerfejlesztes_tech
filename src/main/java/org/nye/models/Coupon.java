package org.nye.models;

import java.time.LocalDate;

public class Coupon {

    private String code;
    private Integer discountAmount; //fix levonás
    private Integer discountPercentage; //százalékos levonás
    private LocalDate expirationDate;

    public Coupon() {
    }

    public Coupon(String code, Integer discountAmount, Integer discountPercentage, LocalDate expirationDate) {
        this.code = code;
        this.discountAmount = discountAmount;
        this.discountPercentage = discountPercentage;
        this.expirationDate = expirationDate;
    }

    public boolean isValid(){
        return LocalDate.now().isBefore(this.expirationDate);
    }

    public double applyDiscount(double orderTotal) {
        if (!isValid()) {
            throw new IllegalStateException("Coupon has expired.");
        }

        if(this.discountAmount != null){
            orderTotal = orderTotal - this.discountAmount;
        }else{
            orderTotal -= orderTotal * (this.discountPercentage/100);
        }

        return orderTotal;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Integer discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDiscountString(){
        if(this.discountAmount != null){
            return "- $" + this.discountAmount;
        }else{
            return "- " + this.discountPercentage + "%";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
            .append("Coupon: ")
            .append(this.code)
            .append(", discount: ")
            .append(this.getDiscountString())
            .append("Expires at:").append(this.expirationDate);

        return sb.toString();
    }
}
