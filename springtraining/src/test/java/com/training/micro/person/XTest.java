package com.training.micro.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.training.micro.rest.FirstRest;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class XTest {

    @Autowired
    private FirstRest firstRest;

    @Test
    public void name() {
        Assertions.assertEquals(this.firstRest,
                                null);
    }


}
