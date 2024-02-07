package test.onebox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import test.onebox.objects.Cart;
import test.onebox.objects.Product;
import test.onebox.services.CartService;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "/application.properties")
class CartServiceTests {

    @Autowired
    private CartService cartService;

    @Test
    void testCreateCart() {
        String cartId = cartService.createCart();
        assertNotNull(cartId);
        assertNotNull(cartService.getCart(cartId));
    }

    @Test
    void testGetCart() {
        String cartId = cartService.createCart();
        Cart cart = cartService.getCart(cartId);
        assertNotNull(cart);
        assertEquals(cartId, cart.getId());
    }

    @Test
    void testAddProductToCart() {
        String cartId = cartService.createCart();
        Product product = new Product("1", "Test Product", 10.0);
        cartService.addProductToCart(cartId, product);
        Cart cart = cartService.getCart(cartId);
        assertNotNull(cart);
        assertNotNull(cart.getProducts());
    }

    @Test
    void testDeleteCart() {
        String cartId = cartService.createCart();
        cartService.deleteCart(cartId);
        assertNull(cartService.getCart(cartId));
    }

}
