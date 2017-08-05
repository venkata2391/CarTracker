package egen.io;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@ComponentScan
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter {
    /*@Override
    public void addCorsMappings(CorsRegistry registry) {

     *//*   registry.addMapping("*//**//**//**//*").allowedMethods("GET","POST","PUT","DELETE")
                .allowedOrigins("http://mocker.egen.io","http://localhost:63342*//**//*")
                .allowedHeaders("Access-Control-Allow-Origin","*")
                .allowedHeaders("accepts","Origin","Access-Control-Allow-Origin","Access-Control-Request-Method")
                .allowCredentials(false).maxAge(3600);
    }*/
}