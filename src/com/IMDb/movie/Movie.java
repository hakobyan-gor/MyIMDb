package com.IMDb.movie;

import com.IMDb.repository.Repository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Movie implements Serializable {

    private Repository<String, Movie> repository = new Repository<>();
    private static final String KEY_VALUE_DIVIDER = " @010/gh010@ ";
    private String title;
    private String description;
    private String genre;
    private int rating;
    private LocalDate premierDate;
    private HashMap<String, String> actors;
    private ArrayList<String> directors;
    private ArrayList<String> screenwriters;
    private int id = repository.getId();

    public Movie() throws FileNotFoundException {
    }

    public Movie(
            String title, String description, String genre,
            LocalDate premierDate, HashMap<String, String> actors,
            ArrayList<String> directors, ArrayList<String> screenwriters
    ) throws FileNotFoundException {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.premierDate = premierDate;
        this.actors = actors;
        this.directors = directors;
        this.screenwriters = screenwriters;
        id++;
    }

    public void addMovie(Movie movie) throws IOException {
        repository.writeDateInFile(String.valueOf(id), movie, "src\\com\\IMDb\\movieAndTVSeriesData\\MovieData.txt");
    }

    public Movie searchMovie(String title) throws IOException {

        Movie movie = null;
        for (int i = 1; i <= repository.getId(); i++) {
            movie = repository.readDataFromFile(String.valueOf(i),"src\\\\com\\\\IMDb\\\\movieAndTVSeriesData\\\\MovieData.txt");
            if (movie.title.equals(title))
                break;
        }

        return movie;
    }

    @Override
    public String toString() {
        return "Title : " + title +
                "\nDescription : " + description +
                "\nGenre : " + genre +
                "\nRating : " + rating +
                "\nPremierDate : " + premierDate +
                "\nActors : " + actors +
                "\nDirectors : " + directors +
                "\nScreenwriters : " + screenwriters;
    }

}
