package productservice8apr.productservice8apr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ConfigurationApplication {
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

}
