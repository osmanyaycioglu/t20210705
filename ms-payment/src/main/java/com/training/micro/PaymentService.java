package com.training.micro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${server.port}")
    private int port;

    public PaymentResponse pay(final PaymentRequest pr) {
        PaymentResponse responseLoc = new PaymentResponse();
        responseLoc.setUid(pr.getUid() + "-" + this.port);
        responseLoc.setSuccess(true);
        responseLoc.setAmount(pr.getAmount());
        return responseLoc;
    }

}
