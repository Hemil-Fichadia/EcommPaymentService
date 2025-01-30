package dev.hemil.EcommPaymentService.controllers;

import com.razorpay.RazorpayException;
import dev.hemil.EcommPaymentService.dtos.InitiatePaymentRequestDto;
import dev.hemil.EcommPaymentService.dtos.PaymentResponse;
import dev.hemil.EcommPaymentService.services.PaymentService;
import dev.hemil.EcommPaymentService.services.strategy.PaymentGatewaySelectionStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService razorpayPaymentService;
    private PaymentService stripePaymentService;
    private PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy;
    public PaymentController(@Qualifier("razorpay")PaymentService razorpayPaymentService,
                             @Qualifier("stripe")PaymentService stripePaymentService){
        this.razorpayPaymentService = razorpayPaymentService;
        this.stripePaymentService = stripePaymentService;
//        this.paymentGatewaySelectionStrategy = paymentGatewaySelectionStrategy;
    }

    @PostMapping("/payment")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) {
        int paymentGatewayOption = choosePaymentGateway();
        switch(paymentGatewayOption){
            case 1 : return razorpayPaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
            case 2 : return stripePaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());
        }
        return null;
    }

    int choosePaymentGateway(){
        return paymentGatewaySelectionStrategy.paymentGatewaySelection();
    }
}
