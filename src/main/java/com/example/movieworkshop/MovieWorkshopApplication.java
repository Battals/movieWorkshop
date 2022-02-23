package com.example.movieworkshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovieWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieWorkshopApplication.class, args);

    }

    @GetMapping("/")
        public String hello(){
        return "Welcome to our application, which provides information about movies";
    }






}
