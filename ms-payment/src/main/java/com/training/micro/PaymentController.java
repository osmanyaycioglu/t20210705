package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService ps;

    @PostMapping("/pay")
    public PaymentResponse pay(@RequestBody final PaymentRequest pr) {
        return this.ps.pay(pr);
    }
}
