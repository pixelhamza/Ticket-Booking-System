package eventsphere.chain;

import eventsphere.model.BookingRequest;
import eventsphere.service.PaymentService;

public final class PaymentHandler extends BookingHandler {
    private final PaymentService paymentService;

    public PaymentHandler(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void handle(BookingRequest request) {
        if (!paymentService.processPayment(request.getSeat().getPrice(), request.getPaymentMethod())) {
            request.getSeat().cancel();
            throw new IllegalStateException("Payment could not be processed.");
        }
        handleNext(request);
    }
}
