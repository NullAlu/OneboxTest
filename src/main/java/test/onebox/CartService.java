package test.onebox;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CartService {
    private Map<String, Cart> carts = new HashMap<>();

    public String createCart() {
        String cartId = String.valueOf(UUID.randomUUID());
        Cart cart = new Cart();
        cart.setId(cartId);
        cart.setProducts(new HashMap<>());
        cart.setExpirationTime(LocalDateTime.now().plusMinutes(10));
        carts.put(cartId, cart);
        return cartId;
    }

    public Cart getCart(String cartId) {
        return carts.get(cartId);
    }

    public void addProductToCart(String cartId, Product product) {
        Cart cart = carts.get(cartId);
        if (cart != null && LocalDateTime.now().isBefore(cart.getExpirationTime())) {
            cart.getProducts().put(product.getId(), product);
        }
    }

    public void deleteCart(String cartId) {
        carts.remove(cartId);
    }
}
