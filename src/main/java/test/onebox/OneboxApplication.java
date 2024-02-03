package test.onebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OneboxApplication {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(OneboxApplication.class, args);
    }
}
