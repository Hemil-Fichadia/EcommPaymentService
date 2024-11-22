package dev.hemil.EcommPaymentService.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import dev.hemil.EcommPaymentService.dtos.PaymentResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorpayPaymentServiceImpl implements PaymentService{

    private RazorpayClient razorpayClient;

    public RazorpayPaymentServiceImpl(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String doPayment(String email, String phoneNumber, Long amount, String orderId) throws RazorpayException {
        /*This is the actual payload that will pass to razorpay while making
        payment request and this is in the form of JSONObject which is similar to
        hashmap but it is dynamic in terms of datatype.
        */
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("receipt", "receipt#1");

        JSONObject customer = new JSONObject();
        customer.put("email", email);
        customer.put("phone",phoneNumber);
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);

        paymentLinkRequest.put("notify", notify);

        paymentLinkRequest.put("callback_url", "https://domain.com/razorpayWebhook");
        paymentLinkRequest.put("callback_method", "get");
        /* Till here we added all the required piece of information like amount,
        phoneNumber that is related to customer we kept all it in customer object
        then notification related medium status enabled we stored inside notify
        object and then stored all inside the main JSONObject paymentRequestLink
        and then passed that paymentRequestLink to the create method of razorpayClient.
        */
        PaymentLink response = razorpayClient.paymentLink.create(paymentLinkRequest);
        return response.toString();
    }
}
