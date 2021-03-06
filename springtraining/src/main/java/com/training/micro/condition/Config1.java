package com.training.micro.condition;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.micro.rest.EnglishSayHello;
import com.training.micro.rest.ISayHello;

@Configuration
@Profile("dev")
//@CheckProp("yukleme")
public class Config1 {

    @Bean
    @Qualifier("xyz")
    public ISayHello createSayHello1() {
        return new EnglishSayHello();
    }

}
