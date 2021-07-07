package com.training.micro.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.micro.models.PaymentRequest;
import com.training.micro.models.PaymentResponse;

@FeignClient("PAYMENT")
@RequestMapping("/payment")
public interface IPaymentClient {

    @PostMapping("/pay")
    public PaymentResponse pay(@RequestBody final PaymentRequest pr);

}
