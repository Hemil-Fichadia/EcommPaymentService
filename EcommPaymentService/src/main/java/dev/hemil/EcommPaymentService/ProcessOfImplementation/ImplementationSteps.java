package dev.hemil.EcommPaymentService.ProcessOfImplementation;

public class ImplementationSteps {
    /* $$$$$$$$$$$$$$$$$$--------------Introduction----------------$$$$$$$$$$$$$$$$$
    This is a payment service, and as any other project, this service
    is in itself a separate project and it only requires to trigger the third
    party payment service provider on receiving the required details and make
    request to make payment.

    -----This project is also using MVC architecture and the structure goes------
    like this

    models - dtos

    controllers

    and services

    where services are related to only PaymentService and as previous services,
    this service will also follow SOLID principle and so it implements <<PaymentService>>
    interface and the actual payment service is
    *******-----RazorpayPaymentServiceImpl-------********

    This service is not storing anything in specific so it won't have any database support
    its simple task is to receive the request of payment and just divert it to
    the third party payment service provider.

    --------------------------Connect to third party API--------------------------
    In order to connect to any third party API with some authentication based
    client recognition, it requires two things
    1) API key
    2) API Secrete
    To wire up all these data, config package is responsible which will contain all related
    configurations and all those class files with responsibility

    Now we have a file class named as RazorPayConfig which will contain those
    credentials which are required to be fed while making a payment request,
    and these credentials will keep updating accordingly and will be transferred
    to those fields of RazorPayConfig class with the help of
    "${variable name with the context it loads with}" ; like razorpay.key.id and
    razorpay.key.secret

    --------------_______Third party payment option_________----------------
    Here we are going to integrate two payment services, and they are
    1) Razorpay payment service
    2) Stripe payment service
    and as we have two payment services, we will inject both these dependencies
    using the constructor injection technique and will also annotate both of them
    using qualifier annotation as there are multiple implementations of an interface,
    and we did used qualifier annotation in product service but there we were using
    either of the product service instances but here we are going to need both of
    them as payment processing will be handled on the basis of availability and
    which company offers service on competitive rate for payments.
    The second most important thing here is, we cannot solely rely on single third
    party payment provider we should have at least two service providers as if
    one goes down while making transaction, we smoothly divert the whole traffic
    to other service provider.

    True incident :-
    Sandeep sir shared a case of an indonesian startup, where sir's friend was
    working for this startup where he was building a payment gateway service
    and behind the scene they were using some other third party payment service
    provider and due to some unforeseen reason, that only integrated service was
    down for the period of 30 days as it was blocked by the government due to
    some speculation going on which seriously affected the trust that
    this company gained among merchants using them and there was no revenue
    gain in this period and that's why, in the software industry, we should
    always make sure we have some backup that can be used when time comes.

    Meanwhile, this payment gateway company also got involved in this issue
    and got blocked for three weeks later they tied up with other payment
    service provider completed all the paperwork and then they have to revived
    in the market again. Now in Business 2 Business market loosing the trust of
    the other business is worst case for a startup or any company, so always
    have a backup ready for such scenarios.

    ----------------__________Payment gateway selection strategy_________--------------
    As we speculated all of our user base, we were having some better deals from
    our payment service providers say razorpay --> 1.5% and stripe --> 1.8% most
    competitive compared to market but we cannot leave stripe without any transactions
    so we decided that, out of 10 transactions, 7 will be done by razorpay and 3
    will be done by stripe, now we have to take care of all these implementation
    as those service providers will only make the payment request on our behalf
    not this kind of stuff, so we have to deign such a functionality in our
    payment service that out of 10 transactions, 7 will be moved to razorpay and
    3 will be diverted to stripe.

    This is a payment service so multiple instances would be running of it
    and so if we think for maintaining a counter then, it will be very difficult
    to maintain a connection among them and if we maintain that count in database
    then DB, then each DB call will result in late response.
    Instead of including any counter or database related functionality, we can
    simply use Math.random() which will generate numbers from 1 to 10 and if
    the number is less than or equal to 7, then divert to razorpay else to stripe
    now this is not straight forward a 7:3 ratio but as the number of request
    rises, Math.random() will maintain this ratio

    --------------___________WebIntegration________------------------
    Here we are integrating the razorpay's web integration, and this can be understood
    by visiting and surfing around the web documentation as we are integrating it
    in our java based pure backend project, our target integration starts from
    installing Java based razorpay SDK from web-integration and
    */
}
