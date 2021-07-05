package com.training.micro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.training.micro.config.ApplicationProp;

@Configuration
public class SayHelloConfig {

    @Autowired
    private Environment     env;

    @Value("${app.language}")
    private String          language;

    @Autowired
    private ApplicationProp appProp;

    @Value("#{applicationProp.language}")
    private String          languageType;

    @Bean
    @Qualifier("dyn")
    public ISayHello createSayHello() {
        switch (this.appProp.getLanguage()) {
            case "eng":
                return new DynamicSayHello("Hello");
            case "tr":
                return new DynamicSayHello("Selam");
            case "esp":
                return new DynamicSayHello("Ola");
            default:
                return new EnglishSayHello();
        }
    }

    @Bean
    @Qualifier("dyn_old")
    public ISayHello createSayHelloOld() {
        switch (this.language) {
            case "eng":
                return new DynamicSayHello("Hello");
            case "tr":
                return new DynamicSayHello("Selam");
            case "esp":
                return new DynamicSayHello("Ola");
            default:
                return new EnglishSayHello();
        }
    }
    //    @Bean
    //    @Qualifier("dyn")
    //    public ISayHello createSayHello() {
    //        String propertyLoc = this.env.getProperty("app.language");
    //        switch (propertyLoc) {
    //            case "eng":
    //                return new DynamicSayHello("Hello");
    //            case "tr":
    //                return new DynamicSayHello("Selam");
    //            case "esp":
    //                return new DynamicSayHello("Ola");
    //            default:
    //                return new EnglishSayHello();
    //        }
    //    }

}
