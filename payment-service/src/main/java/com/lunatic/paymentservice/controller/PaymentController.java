package com.lunatic.paymentservice.controller;

import com.lunatic.paymentservice.model.Payment;
import com.lunatic.paymentservice.repository.PaymentRepository;
import com.lunatic.paymentservice.util.Signature;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SignatureException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/payment/api/")
public class PaymentController {

    private static final String RAZORPAY_KEY = "rzp_test_7KSgMgR4V5kTSL";
    private static final String RAZORPAY_SECRET = "iChl8P7TigOw4wAkxPGHWfae";


    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/payments")
    public List<Payment> getPayments(){
        return paymentRepository.findAll();
    }

    @PostMapping("/create_order")
    public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
    	double amountDb = Double.parseDouble(data.get("amount").toString());
        
        // Convert the double to an integer (cast or round)
        int amount = (int) amountDb; 
        RazorpayClient razorpayClient = new RazorpayClient(RAZORPAY_KEY, RAZORPAY_SECRET);

        JSONObject ob = new JSONObject();
        ob.put("amount", amount*100);
        ob.put("currency", "INR");
        ob.put("receipt", "rec_"+amount);

        Order order = razorpayClient.orders.create(ob);
        System.out.println(order);
        return order.toString();
    }
    
    @PostMapping("/mockPayment")
    public com.razorpay.Payment captureMockedPayment(@RequestBody Map<String, Object> data) throws RazorpayException{
        double amountDb = Double.parseDouble(data.get("amount").toString());
        
        // Convert the double to an integer (cast or round)
        int amount = (int) amountDb; 
        
    	// Now capture this mock payment id
    	com.razorpay.Payment payment = null;
    	try {
    	    RazorpayClient razorpayClient = new RazorpayClient(RAZORPAY_KEY, RAZORPAY_SECRET);

    	    // Capture with mock ID (this won't actually capture but shows the flow)
    	    JSONObject captureRequest = new JSONObject();
    	    captureRequest.put("amount", amount*100); // Mock amount in paise

    	    JSONObject paymentRequest = new JSONObject();
    	    paymentRequest.put("amount", 50000); // amount in paise
    	    paymentRequest.put("currency", "INR");
    	    paymentRequest.put("order_id", data.get("order_id").toString()); // Generated test order_id

    	    payment = razorpayClient.payments.createUpi(paymentRequest);
    	    String paymentId = payment.get("id");
    	    
    	    System.out.println("Using Mock Payment ID: " + paymentId);

    	    // This step will fail since the ID is fake, but illustrates the flow
    	    payment = razorpayClient.payments.capture(paymentId, captureRequest);
    	    System.out.println("Captured Payment: " + payment);
    	} catch (RazorpayException e) {
    	    System.out.println("This will fail as it's mock: " + e.getMessage());
    	}
		return payment;
    }
    
    

    @PostMapping("/payment")
    public ResponseEntity<?> createPayment(@RequestBody Payment payment) throws SignatureException {
        String generatedSignature = Signature.calculateRFC2104HMAC(payment.getRazorpayOrderId() + "|" +payment.getRazorpayPaymentId(), "iChl8P7TigOw4wAkxPGHWfae");
        System.out.println("Captured Payment: " + generatedSignature);
            payment.setPaymentDateTime(LocalDateTime.now());
            payment.setRazorpaySignature(generatedSignature);
            return ResponseEntity.ok(paymentRepository.save(payment));
    }

}
