package dev.hemil.EcommPaymentService.services.strategy;

public class PaymentGatewaySelectionStrategyImpl implements PaymentGatewaySelectionStrategy{
    @Override
    public int paymentGatewaySelection() {
        int randomNumber = (int)(Math.random() * 10) + 1;
        if(randomNumber <= 7){
            return 1;
        }
        return 2;
    }
}
