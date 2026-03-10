package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        return null;
    }
}