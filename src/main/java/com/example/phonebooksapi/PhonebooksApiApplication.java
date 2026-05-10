package com.example.phonebooksapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.phonebooksapi")
public class PhonebooksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonebooksApiApplication.class, args);
    }

}
