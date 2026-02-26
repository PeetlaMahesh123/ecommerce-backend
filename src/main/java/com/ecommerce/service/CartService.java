package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.entity.Cart;
import com.ecommerce.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository repository;

    public Cart addToCart(Cart cart) {
        return repository.save(cart);
    }

    public List<Cart> getCart(Long userId) {
        return repository.findByUserId(userId);
    }
    
    public void removeCart(Long cartId) {
        repository.deleteById(cartId);
    }
}