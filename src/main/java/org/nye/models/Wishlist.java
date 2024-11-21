package org.nye.models;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {

    private User user;
    private List<Product> items;

    public Wishlist(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public List<Product> getItems() {
        return items;
    }

    public boolean addItem(Product item) {
        if (items.contains(item)) {
            return false; // Item already in the wishlist
        }
        items.add(item);
        return true;
    }

    public boolean removeItem(Product item) {
        return items.remove(item);
    }

    public boolean containsItem(Product item) {
        return items.contains(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wishlist for: ")
                .append(this.user.getName())
                .append("\r Products:");
        for (Product prod: this.items){
            sb.append("\r").append(prod.getName());
        }
        return sb.toString();
    }
}