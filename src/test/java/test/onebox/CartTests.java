package test.onebox;

import org.junit.jupiter.api.Test;
import test.onebox.objects.Cart;
import test.onebox.objects.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CartTests {

    @Test
    void testGettersAndSetters() {

        Cart cart = new Cart();

        String cartId = "123";
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(10);
        Map<Integer, Product> products = new HashMap<>();

        cart.setId(cartId);
        cart.setExpirationTime(expirationTime);
        cart.setProducts(products);

        //Verify inputs
        assertEquals(cartId, cart.getId());
        assertEquals(expirationTime, cart.getExpirationTime());
        assertEquals(products, cart.getProducts());
    }
}
