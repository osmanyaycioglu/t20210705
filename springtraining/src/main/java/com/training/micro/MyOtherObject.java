package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class MyOtherObject {

    private int      counter;

    @Autowired
    private MyObject myObject;

    public void sayHello() {
        this.counter++;
        System.out.println("Saying : " + this.counter);
        this.myObject.hello();
    }

    public MyObject getMyObject() {
        return this.myObject;
    }

    public void setMyObject(final MyObject myObjectParam) {
        this.myObject = myObjectParam;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(final int counterParam) {
        this.counter = counterParam;
    }

}

