package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("esp")
public class SpanishSayHello implements ISayHello {

    @Override
    public String hello(final String nameParam) {
        return "Ola " + nameParam;
    }

}
