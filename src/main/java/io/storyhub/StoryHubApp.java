package io.storyhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main class for Spring Boot execution.
 *
 * @author chanwook
 */
@SpringBootApplication
@RestController
public class StoryHubApp {

    @RequestMapping("/greeting")
    public String greeting() {
        return "Hello~";
    }

    public static void main(String[] args) {
        SpringApplication.run(StoryHubApp.class, args);
    }
}
