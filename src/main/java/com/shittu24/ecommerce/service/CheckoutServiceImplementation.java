package com.shittu24.ecommerce.service;

import com.shittu24.ecommerce.dao.CustomerRepository;
import com.shittu24.ecommerce.dto.Purchase;
import com.shittu24.ecommerce.dto.PurchaseResponse;
import com.shittu24.ecommerce.entity.Customer;
import com.shittu24.ecommerce.entity.Order;
import com.shittu24.ecommerce.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceImplementation implements CheckoutService {

    private CustomerRepository customerRepository;
    public CheckoutServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();

        // check if this is an existing customer ...
        String theEmail = customer.getEmail();

        Customer customerFromDB = customerRepository.findByEmail(theEmail);

        if (customerFromDB != null) {
        // we found them ... let's assign them accordingly
            customer = customerFromDB;
        }

        // add the order to the customer
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        
        return UUID.randomUUID().toString();
    }
}
