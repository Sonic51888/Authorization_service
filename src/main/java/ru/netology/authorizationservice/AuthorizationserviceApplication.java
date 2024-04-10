package ru.netology.authorizationservice;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AuthorizationserviceApplication {
//    @Value("${server.port}")
//    private int port;

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationserviceApplication.class, args);
    }

}
