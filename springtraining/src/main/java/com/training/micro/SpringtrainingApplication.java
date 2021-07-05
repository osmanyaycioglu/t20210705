package com.training.micro;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringtrainingApplication {

    @Autowired
    private ApplicationContext ac;

    @Autowired
    private MyOtherObject      myOtherObject1;

    //@Autowired
    public SpringtrainingApplication(final MyOtherObject myOtherObject2) {
        int counterLoc = myOtherObject2.getCounter();
        if (counterLoc > 10) {
            myOtherObject2.setCounter(counterLoc);
        }
        this.myOtherObject2 = myOtherObject2;
    }

    private final MyOtherObject myOtherObject2;

    private MyOtherObject       myOtherObject3;

    @Autowired
    private MyOtherObject       myOtherObject4;

    @PostConstruct
    public void abc() {
        int counterLoc = this.myOtherObject1.getCounter();
        if (counterLoc > 10) {
            this.myOtherObject1.setCounter(counterLoc);
        }
    }

    @PreDestroy
    public void ufc() {
        System.out.println("Destroy");
    }

    @Autowired
    public void methodXYZ(final MyOtherObject myOtherObject3) {
        this.myOtherObject3 = myOtherObject3;
    }

    public void doSay() {
        MyOtherObject beanLoc = this.ac.getBean(MyOtherObject.class);
        beanLoc.sayHello();

        this.myOtherObject1.sayHello();
        this.myOtherObject2.sayHello();
        this.myOtherObject3.sayHello();
        this.myOtherObject4.sayHello();
    }
}
