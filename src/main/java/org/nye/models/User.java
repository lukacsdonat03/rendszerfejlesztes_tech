package org.nye.models;

import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private String email;
    private String password;
    private UserRole role;
    private Wishlist wishlist;

    //Memóriában történő tárolás
    private static Map<String, User> userDatabase = new HashMap<>();

    public User() {
    }

    public User(String name, String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = this.hashPassword(password);
        this.role = role;
        this.wishlist = new Wishlist(this);
    }


    public String roleToString(){
        if(this.role == UserRole.USER){
            return "user";
        } else if (this.role == UserRole.ADMIN) {
            return "admin";
        }else{
            return "super admin";
        }
    }

    public static String register(String name, String email, String password, UserRole role) {
        if (userDatabase.containsKey(email)) {
            return "Registration failed: Email is already in use.";
        }
        User newUser = new User(name, email, password, role);
        userDatabase.put(email, newUser);
        return "Registration successful for user: " + name;
    }

    public static String login(String email, String password) {
        User user = userDatabase.get(email);
        if (user == null) {
            return "Login failed: User not found.";
        }
        if (user.checkPassword(password)) {
            return "Login successful! Welcome, " + user.getName() + ". Role: " + user.roleToString();
        } else {
            return "Login failed: Incorrect password.";
        }
    }

    public static void listUsers() {
        userDatabase.values().forEach(System.out::println);
    }

    private String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public boolean checkPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, this.password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ")
                .append(this.name)
                .append(", email: ")
                .append(this.email)
                .append(this.roleToString());

        return sb.toString();
    }
}
