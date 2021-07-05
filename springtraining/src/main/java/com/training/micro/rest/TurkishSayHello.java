package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tr")
public class TurkishSayHello implements ISayHello {

    @Override
    public String hello(final String nameParam) {
        return "Merhaba " + nameParam;
    }

}
