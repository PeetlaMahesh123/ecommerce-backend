package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.Cart;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.CartRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    public Order placeOrder(Long userId) {

        List<Cart> cartItems = cartRepository.findByUserId(userId);

        double total = 0;

        for(Cart item : cartItems) {
            total += item.getQuantity() * 100; // example price logic
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);

        cartRepository.deleteAll(cartItems);

        return orderRepository.save(order);
    }

    public List<Order> getOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}