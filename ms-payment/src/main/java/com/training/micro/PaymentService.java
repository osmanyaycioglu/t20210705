package com.training.micro;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentResponse pay(final PaymentRequest pr) {
        PaymentResponse responseLoc = new PaymentResponse();
        responseLoc.setUid(pr.getUid());
        responseLoc.setSuccess(true);
        responseLoc.setAmount(pr.getAmount());
        return responseLoc;
    }

}
