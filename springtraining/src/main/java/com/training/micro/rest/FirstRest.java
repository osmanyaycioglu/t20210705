package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.SpringtrainingApplication;

//@Service
//@Repository
//@Controller
//@Configuration

@RestController
@RequestMapping("/first")
public class FirstRest {

    @Autowired
    private SpringtrainingApplication sa;

    @Autowired
    @Qualifier("dyn")
    private ISayHello                 sh;

    @GetMapping("/hello/{abc}")
    public String hello(@PathVariable("abc") final String name) {
        this.sa.doSay();
        return this.sh.hello(name);
    }

    @Autowired
    @Qualifier("xyz")
    private ISayHello sh2;

    @GetMapping("/hello2/{abc}")
    public String hello2(@PathVariable("abc") final String name) {
        return this.sh2.hello(name);
    }

}
