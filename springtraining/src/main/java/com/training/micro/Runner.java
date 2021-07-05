package com.training.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Runner {

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringtrainingApplication.class,
                                                                       args);
        MyOtherObject beanLoc = context.getBean(MyOtherObject.class);
        beanLoc.sayHello();

        SpringtrainingApplication bean2Loc = context.getBean(SpringtrainingApplication.class);
        bean2Loc.doSay();
        //        bean2Loc.doSay();
        //        bean2Loc.doSay();
        //        bean2Loc.doSay();

        //        MyObject myObjectLoc = new MyObject();
        //        MyOtherObject myOtherObjectLoc = new MyOtherObject();
        //        myOtherObjectLoc.setMyObject(myObjectLoc);
        //        myOtherObjectLoc.sayHello();


    }
}
