package dev.hemil.EcommPaymentService.services;

import dev.hemil.EcommPaymentService.dtos.PaymentResponse;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentServiceImpl implements PaymentService {
    @Override
    public String doPayment(String email, String phoneNumber, Long amount, String orderId) {
        return null;
    }
}
