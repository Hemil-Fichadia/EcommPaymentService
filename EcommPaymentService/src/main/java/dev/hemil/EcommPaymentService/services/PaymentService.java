package dev.hemil.EcommPaymentService.services;


import com.razorpay.RazorpayException;
import dev.hemil.EcommPaymentService.dtos.PaymentResponse;

public interface PaymentService {
    String doPayment(String email, String phoneNumber, Long amount, String orderId) throws RazorpayException;
}
