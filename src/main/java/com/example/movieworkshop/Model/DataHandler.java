package com.example.movieworkshop.Model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataHandler {

    File fil = new File("imdb-data.csv");
    String[] info;
    int movieCounter = 0;
    ArrayList<Movie> movieList = new ArrayList<>();
    ArrayList<Movie> randomPopularityList = new ArrayList<>();
    ArrayList<Movie> aList = new ArrayList<>();


    public String getFirst() throws IOException {

        return converter(1).title;
    }

    public String getRandom() throws FileNotFoundException {
        Random rnd = new Random();
        String randomTitle = converter(rnd.nextInt(100)).title;

        return randomTitle;
    }


    public ArrayList<Movie> randomList() throws FileNotFoundException {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            randomPopularityList.add(converter(rnd.nextInt(1000)));
        }
        Collections.sort(randomPopularityList, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Integer.compare(o1.getPopularity(), o2.getPopularity());
            }
        });

        return randomPopularityList;

    }

    public int awards() throws FileNotFoundException {
        Scanner sc = new Scanner(fil);
        for (int i = 2; i < 1584; i++) {
            if (converter(i).awards.equalsIgnoreCase("yes")) {
                movieCounter++;
            }
        }
        return movieCounter;
    }


    public boolean booleanConverter(String line) {
        if (line.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    private Movie converter(int number) throws FileNotFoundException {
        Scanner convertScanner = new Scanner(fil);
        String movieLine = "";
        convertScanner.nextLine();
        for (int i = 0; i != number; i++) {
            movieLine = convertScanner.nextLine();
        }
        info = movieLine.split(";");

        int year = Integer.parseInt(info[0]);
        int length = Integer.parseInt(info[1]);
        String title = info[2];
        String subject = info[3];
        int popularity = Integer.parseInt(info[4]);
        String awards = (info[5]);
        Movie a = new Movie(year, length, title, subject, popularity, awards);

        return a;
    }

    public ArrayList<Movie> characterN(String x, int n) throws FileNotFoundException {
        Scanner sc = new Scanner(fil);
        int counter = 0;
        int y = 2;
        while (sc.hasNextLine()) {
            if (converter(y).title.toLowerCase(Locale.ROOT).contains(x)) {
                String titel = converter(y).title;
                for (int i = 0; i < titel.length(); i++) {
                    if (String.valueOf(titel.charAt(i)).equalsIgnoreCase(x)) {
                        counter++;
                    }
                    if (counter == n) {
                        aList.add(converter(y));
                    }
                }
            }

        }
        return aList;
    }


}
