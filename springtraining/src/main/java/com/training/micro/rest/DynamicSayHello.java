package com.training.micro.rest;


public class DynamicSayHello implements ISayHello {

    private final String prefix;

    public DynamicSayHello(final String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String hello(final String nameParam) {
        return this.prefix + " " + nameParam;
    }


}
