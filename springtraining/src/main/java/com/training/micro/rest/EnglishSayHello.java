package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Primary
@Qualifier("eng")
@Component
public class EnglishSayHello implements ISayHello {

    @Override
    public String hello(final String nameParam) {
        return "Hello " + nameParam;
    }

}
