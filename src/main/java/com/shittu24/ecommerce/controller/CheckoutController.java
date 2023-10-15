package com.shittu24.ecommerce.controller;

import com.shittu24.ecommerce.dto.Purchase;
import com.shittu24.ecommerce.dto.PurchaseResponse;
import com.shittu24.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
