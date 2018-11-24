package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class WelcomeController {

    @Value("${WELCOME_MESSAGE}")
    private String welcomeMessage;

    /*@Value("${WELCOME_MESSAGE}")
    @Value("#{ systemProperties['user.region'] }")
    public void setWelcomeMessage(String msg) {
        this.welcomeMessage = msg;
    }*/

    @GetMapping("/")
    public String sayHello() {
        return welcomeMessage;
    }
}