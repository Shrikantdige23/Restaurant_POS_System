package com.restaurant.demo.controller;

import com.restaurant.demo.model.KOT;
import com.restaurant.demo.model.Order;
import com.restaurant.demo.model.OrderItem;
import com.restaurant.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Place a New Order
//    @PostMapping("/place")
//    public Order placeOrder(@RequestParam int tableNumber, @RequestBody List<OrderItem> items) {
//        return orderService.placeOrder(tableNumber, items);
//    }
    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order orderRequest) {
        return orderService.placeOrder(orderRequest.getTableNumber(), orderRequest.getItems());
    }

    // Add Extra Order
    @PutMapping("/add-extra")
    public Order addExtraOrder(@RequestParam int tableNumber, @RequestBody List<OrderItem> extraItems) {
        return orderService.addExtraOrder(tableNumber, extraItems);
    }
    
    @GetMapping("/generate-kot/{tableNumber}")
    public ResponseEntity<KOT> generateKOT(@PathVariable int tableNumber) {
        Order order = orderService.getLatestOrderForTable(tableNumber);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        KOT kot = orderService.generateKOT(tableNumber, order.getItems());
        return ResponseEntity.ok(kot);
    }

    
    }
