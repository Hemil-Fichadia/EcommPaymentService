package dev.hemil.EcommPaymentService.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {
    /* This is the Id and password that RazorPay provides to its clients in order
    to make payment request
    */
    /* @Value() annotation will fetch the values from application.properties
    file and keep updated these fields of config file.
    */
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    /* We need this RazorpayClient object at the project context level
    as we want to have the access of this functionality as this is the method,
    which will enable the connection of making the payment request with
    essential payload and this we are using in the service for receiving
    the payment link.
    */
    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }
}
