package com.example.movieworkshop.APP;


import com.example.movieworkshop.Model.DataHandler;
import com.example.movieworkshop.Model.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class MovieWorkshopApplication {
    DataHandler dh = new DataHandler();

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MovieWorkshopApplication.class, args);


    }

    @GetMapping("/")
    public String hello(){
        return "Welcome to my application, which provides information about several movies";
    }

    @GetMapping("/getFirst")
    public String firstTitle() throws IOException {
        return dh.getFirst();
    }

    @GetMapping("/getRandom")
    public String rndTitle() throws FileNotFoundException {
        return dh.getRandom();
    }

    @GetMapping("/getTenSortByPopularity")
    public ArrayList<Movie> tenPopularitySorted() throws FileNotFoundException {
        return dh.randomList();
    }


    @GetMapping("/howManyWonAnAward")
    public int moviesWithAwards() throws FileNotFoundException {
        return dh.awards();
    }

    //Bugged
    @GetMapping("/filter?char='x'amount='n'")
    public ArrayList<Movie> filter() throws FileNotFoundException {
        return dh.characterN("n",3);
    }

    //3.7
    //Under progress















}
