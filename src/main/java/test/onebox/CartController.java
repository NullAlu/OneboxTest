package test.onebox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public String createCart() {
        return cartService.createCart();
    }

    @GetMapping("/get/{cartId}")
    public Cart getCart(@PathVariable String cartId) {
        return cartService.getCart(cartId);
    }

    @PostMapping("/add/{cartId}")
    public void addProductToCart(@PathVariable String cartId, @RequestBody Product product) {
        cartService.addProductToCart(cartId, product);
    }

    @DeleteMapping("/delete/{cartId}")
    public void deleteCart(@PathVariable String cartId) {
        cartService.deleteCart(cartId);
    }
}
