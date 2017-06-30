package egen.io;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@ComponentScan
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter{
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                    corsRegistry.addMapping("*//*").allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedOrigins("http://mocker.egen.io/?").allowedHeaders("accepts", "Origin",
                        "Access-Control-Request-Method", "Access-Control-Request-Method")
                        .allowCredentials(false).maxAge(3600);
            }
}