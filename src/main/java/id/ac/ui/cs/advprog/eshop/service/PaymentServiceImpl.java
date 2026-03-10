package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        Payment payment = new Payment(java.util.UUID.randomUUID().toString(), method, paymentData);

        if (method.equals("VOUCHER")) {
            String code = paymentData.get("voucherCode");
            if (code != null && code.length() == 16 && code.startsWith("ESHOP") &&
                    code.replaceAll("\\D", "").length() == 8) {
                payment.setStatus("SUCCESS");
            } else {
                payment.setStatus("REJECTED");
            }
        } else if (method.equals("BANK_TRANSFER")) {
            String bank = paymentData.get("bankName");
            String ref = paymentData.get("referenceCode");
            if (bank != null && !bank.isEmpty() && ref != null && !ref.isEmpty()) {
                payment.setStatus("SUCCESS");
            } else {
                payment.setStatus("REJECTED");
            }
        }

        if (payment.getStatus().equals("SUCCESS")) {
            order.setStatus("SUCCESS");
        } else {
            order.setStatus("FAILED");
        }

        return paymentRepository.save(payment);
    }
}