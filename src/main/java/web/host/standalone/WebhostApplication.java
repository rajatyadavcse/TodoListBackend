package web.host.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("web.host")
@EntityScan("web.host")
@ConfigurationPropertiesScan("web.host")
@EnableJpaRepositories("web.host")
public class WebhostApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebhostApplication.class, args);
    }
}
