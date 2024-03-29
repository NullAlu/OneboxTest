package test.onebox.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.onebox.objects.Cart;
import test.onebox.objects.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CartService {
    private Map<String, Cart> carts = new HashMap<>();

    public String createCart() {
        String cartId = UUID.randomUUID().toString(); //Unique ID
        Cart cart = new Cart();
        cart.setId(cartId);
        cart.setProducts(new HashMap<>());
        cart.setExpirationTime(LocalDateTime.now().plusMinutes(10)); //Expiration set to 10 minutes
        carts.put(cartId, cart);
        return cartId;
    }

    public Cart getCart(String cartId) {
        return carts.get(cartId);
    }

    public void addProductToCart(String cartId, Product product) {
        Cart cart = carts.get(cartId);
        if (cart != null) {
            cart.getProducts().put(product.getId(), product);
        }
    }

    public void deleteCart(String cartId) {
        carts.remove(cartId);
    }

}
