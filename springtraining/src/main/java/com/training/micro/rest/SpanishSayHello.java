package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@DependsOn()
@Qualifier("esp")
public class SpanishSayHello implements ISayHello {

    @Override
    public String hello(final String nameParam) {
        return "Ola " + nameParam;
    }

}
