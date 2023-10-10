package com.shittu24.ecommerce.service;

import com.shittu24.ecommerce.dto.Purchase;
import com.shittu24.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
