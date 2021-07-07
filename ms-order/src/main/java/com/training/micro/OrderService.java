package com.training.micro;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.micro.clients.IPaymentClient;
import com.training.micro.models.PaymentRequest;
import com.training.micro.models.PaymentResponse;

@Service
public class OrderService {

    private final AtomicLong requestIndex = new AtomicLong();

    @Autowired
    private RestTemplate     rt;

    @Autowired
    private EurekaClient     ec;

    @Autowired
    private IPaymentClient   pc;

    public String place3(final Order orderParam) {
        PaymentRequest requestLoc = new PaymentRequest();
        requestLoc.setName(orderParam.getName());
        requestLoc.setRequestId(this.requestIndex.incrementAndGet());
        requestLoc.setUid(UUID.randomUUID()
                              .toString());
        requestLoc.setAmount(new BigDecimal(100));

        PaymentResponse payLoc = this.pc.pay(requestLoc);

        if (payLoc.getSuccess()) {
            return "SUCCESS " + payLoc.getUid();
        } else {
            return "FAILED";
        }
    }

    public String place(final Order orderParam) {
        PaymentRequest requestLoc = new PaymentRequest();
        requestLoc.setName(orderParam.getName());
        requestLoc.setRequestId(this.requestIndex.incrementAndGet());
        requestLoc.setUid(UUID.randomUUID()
                              .toString());
        requestLoc.setAmount(new BigDecimal(100));

        PaymentResponse pr = this.rt.postForObject("http://PAYMENT/payment/pay",
                                                   requestLoc,
                                                   PaymentResponse.class);
        if (pr.getSuccess()) {
            return "SUCCESS " + pr.getUid();
        } else {
            return "FAILED";
        }
    }

    public String place2(final Order orderParam) {
        Application applicationLoc = this.ec.getApplication("PAYMENT");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println("PAYMENT : " + instanceInfoLoc.getIPAddr() + ":" + instanceInfoLoc.getPort());
        }
        PaymentRequest requestLoc = new PaymentRequest();
        requestLoc.setName(orderParam.getName());
        requestLoc.setRequestId(this.requestIndex.incrementAndGet());
        requestLoc.setUid(UUID.randomUUID()
                              .toString());
        requestLoc.setAmount(new BigDecimal(100));
        RestTemplate restTemplateLoc = new RestTemplate();
        InstanceInfo nextLoc = this.ec.getNextServerFromEureka("PAYMENT",
                                                               false);

        PaymentResponse pr = restTemplateLoc.postForObject("http://"
                                                           + nextLoc.getIPAddr()
                                                           + ":"
                                                           + nextLoc.getPort()
                                                           + "/payment/pay",
                                                           requestLoc,
                                                           PaymentResponse.class);
        if (pr.getSuccess()) {
            return "SUCCESS " + pr.getUid();
        } else {
            return "FAILED";
        }
    }

}
