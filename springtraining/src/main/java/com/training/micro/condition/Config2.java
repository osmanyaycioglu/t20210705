package com.training.micro.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.micro.rest.ISayHello;
import com.training.micro.rest.TurkishSayHello;

@Configuration
@CheckProp("yukleme")
public class Config2 {

    @Bean
    @Qualifier("xyz2")
    public ISayHello createSayHello2() {
        return new TurkishSayHello();
    }

}
