package test.onebox.objects;

import java.time.LocalDateTime;
import java.util.Map;


public class Cart {
    private String id;
    private Map<Integer, Product> products;
    private LocalDateTime expirationTime;

    // Constructor, getters, and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
