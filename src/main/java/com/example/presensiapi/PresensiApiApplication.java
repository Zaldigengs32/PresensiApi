package com.example.presensiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.presensiapi")
public class PresensiApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PresensiApiApplication.class, args);
    }
}
