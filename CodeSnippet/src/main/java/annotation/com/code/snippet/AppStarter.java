package annotation.com.code.snippet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStarter {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AppStarter.class);
        app.run();
    }
}
