package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.UUID;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        Payment payment = new Payment(UUID.randomUUID().toString(), method, paymentData);

        if (method.equals("VOUCHER")) {
            if (isVoucherValid(paymentData.get("voucherCode"))) {
                payment.setStatus("SUCCESS");
            } else {
                payment.setStatus("REJECTED");
            }
        } else if (method.equals("BANK_TRANSFER")) {
            if (isBankTransferValid(paymentData)) {
                payment.setStatus("SUCCESS");
            } else {
                payment.setStatus("REJECTED");
            }
        }

        updateOrderStatus(order, payment.getStatus());
        return paymentRepository.save(payment);
    }

    private boolean isVoucherValid(String code) {
        return code != null && code.length() == 16 &&
                code.startsWith("ESHOP") &&
                code.replaceAll("\\D", "").length() == 8;
    }

    private boolean isBankTransferValid(Map<String, String> data) {
        String bankName = data.get("bankName");
        String refCode = data.get("referenceCode");
        return bankName != null && !bankName.isEmpty() &&
                refCode != null && !refCode.isEmpty();
    }

    private void updateOrderStatus(Order order, String paymentStatus) {
        if (paymentStatus.equals("SUCCESS")) {
            order.setStatus("SUCCESS");
        } else {
            order.setStatus("FAILED");
        }
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        payment.setStatus(status);
        updateOrderStatus(null, status); // Perlu penyesuaian objek order jika ingin diimplementasikan penuh
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}