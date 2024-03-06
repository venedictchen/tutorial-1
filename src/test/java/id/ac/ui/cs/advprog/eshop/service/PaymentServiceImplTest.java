package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    @InjectMocks
    PaymentService paymentService;
    @Mock
    PaymentRepository paymentRepository;
    List<Order> orders;
    List<Payment> payments;

    @BeforeEach
    void setUp(){
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Order order = new Order("13652556-012a-4c07-b546-54eb1396d79b", products,
                1708560000L, "Safira Sudarajat");
        orders.add(order);

        payments = new ArrayList<>();
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP00000000AAA");
        Payment payment1 = new Payment( order,
                "VOUCHER", paymentData );
        payments.add(payment1);
        paymentData.clear();
        paymentData.put("bankName","BCA");
        paymentData.put("referenceCode","7");
        Payment payment2 = new Payment(order, "BANK", paymentData);
        payments.add(payment2);
    }

    @Test
    void testAddPayment(){
        Payment payment1 = payments.get(0);
        doReturn(payment1).when(paymentRepository).save(payment1);
        payment1 = paymentService.addPayment(payment1.getOrder(), "VOUCHER", payment1.getPaymentData());

        Payment payment2 = payments.get(1);
        doReturn(payment2).when(paymentRepository).save(payment2);
        payment2 = paymentService.addPayment(payment2.getOrder(), "BANK", payment2.getPaymentData());
        Payment findResult = paymentService.getPayment(payment1.getId());

        assertEquals(payment1.getId(),findResult.getId() );
        assertEquals(payment1.getMethod(), findResult.getMethod() );
        assertEquals(payment1.getStatus(), findResult.getStatus() );

        findResult = paymentService.getPayment(payment2.getId());

        assertEquals(payment2.getId(),findResult.getId() );
        assertEquals(payment2.getMethod(), findResult.getMethod() );
        assertEquals(payment2.getStatus(), findResult.getStatus() );
    }

    @Test
    void testGetPaymentIfFound(){
        Payment payment1 = payments.get(0);
        doReturn(payment1).when(paymentRepository).findById(payment1.getId());
        Payment paymentFound = paymentService.getPayment(payment1.getId());
        assertEquals(payment1.getId(), paymentFound.getId());
        assertEquals("VOUCHER",paymentFound.getMethod());
        assertEquals(payment1.getStatus(), paymentFound.getStatus());
    }

    @Test
    void testGetPaymentIfNotFound(){
        doReturn(null).when(paymentRepository).findById("zczc");
        Payment payment = paymentService.getPayment("zczc");
        assertNull(payment);
    }

    @Test
    void testGetAllPayment(){
        doReturn(payments).when(paymentRepository).getAllPayments();
        List<Payment> payment = paymentService.getAllPayment();
        assertNull(payment);
    }

    @Test
    void testSetStatusSuccessful(){
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP00000000AAA");
        Payment payment1 = new Payment(orders.get(0), "VOUCHER", paymentData);

        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(),payment1.getStatus());
        paymentService.setStatus(payment1, PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(),payment1.getStatus());
        paymentService.setStatus(payment1, PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(),payment1.getStatus());
    }

    @Test
    void testSetStatusFail(){
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode","ESHOP00000000AAA");
        Payment payment1 = paymentService.addPayment(orders.get(0), "VOUCHER", paymentData);
        assertThrows(IllegalArgumentException.class, ()->
                paymentService.setStatus(payment1, "mewo")
        );
    }


}