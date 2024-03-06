package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PaymentService {
    Payment addPayment(Order order, String method, Map<String, String> paymentData);
    List<Payment> getAllPayment();
    void setStatus(Payment payment, String status);
    Payment getPayment(String id);
}