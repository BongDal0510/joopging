package com.team4.joopging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JoopgingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoopgingApplication.class, args);
    }

}
