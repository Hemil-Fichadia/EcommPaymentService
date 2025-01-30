package dev.hemil.EcommPaymentService.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("razorpayWebhook")
public class RazorpayWebHookController {

    public ResponseEntity acceptWebHookRequest(){

        // redirect to UI
        /* This controller's task is to redirect the payment request to
        razorpay's UI and from there razorpay will take on to the pop-up
        screen where one is supposed to insert card details and make the
        payment.
        */
        return null;
    }
}
