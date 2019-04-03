package ko.maeng.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

    //@EnableJpaAuditing Auditing된 애노테이션 모두 활성화.

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
