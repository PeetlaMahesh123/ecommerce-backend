package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.Cart;
import com.ecommerce.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return service.addToCart(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Long userId) {
        return service.getCart(userId);
    }

    @DeleteMapping("/{cartId}")
    public String removeCart(@PathVariable Long cartId) {

        service.removeCart(cartId);

        return "Item removed";
    }
}