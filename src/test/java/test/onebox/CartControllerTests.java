package test.onebox;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import test.onebox.controllers.CartController;
import test.onebox.objects.Cart;
import test.onebox.services.CartService;

import java.util.HashMap;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(locations = "/application.properties")
class CartControllerTests {

    private MockMvc mockMvc;

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    @Test
    void testCreateCart() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();

        String cartId = "12345";
        when(cartService.createCart()).thenReturn(cartId);

        //Verify POST status
        mockMvc.perform(post("/cart/create")).andExpect(status().isOk());
    }

    @Test
    void testDeleteCart() throws Exception {

        //Verify DELETE status
        mockMvc.perform(delete("/cart/delete/{cartId}", "12345")).andExpect(status().isOk());
    }

    @Test
    void testGetCart() throws Exception {

        Cart cart = new Cart();
        cart.setId("12345");
        cart.setProducts(new HashMap<>());

        when(cartService.getCart("12345")).thenReturn(cart);

        //Verify GET status
        mockMvc.perform(get("/cart/get/{cartId}", "12345")).andExpect(status().isOk());
    }
}
