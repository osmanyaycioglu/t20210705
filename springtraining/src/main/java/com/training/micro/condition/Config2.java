package com.training.micro.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.micro.rest.ISayHello;
import com.training.micro.rest.TurkishSayHello;

@Configuration
//@CheckProp("yukle")
@Profile("live")
public class Config2 {

    @Bean
    @Qualifier("xyz")
    public ISayHello createSayHello2() {
        return new TurkishSayHello();
    }

}
