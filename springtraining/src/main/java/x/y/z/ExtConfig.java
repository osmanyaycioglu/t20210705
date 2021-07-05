package x.y.z;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExtConfig {

    @Bean
    public MyExternalObject myExternalObject() {
        return new MyExternalObject();
    }

}
