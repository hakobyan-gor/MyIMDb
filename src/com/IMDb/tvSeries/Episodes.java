package com.IMDb.tvSeries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Episodes {

    private String title;
    private Double rating;
    private LocalDate premierDate;
    private HashMap<String, String> actors;
    private ArrayList<String> directors;
    private ArrayList<String> screenwriters;
    private int episodeNumber;

    public Episodes(
            String title, Double rating, LocalDate premierDate,
            HashMap<String, String> actors, ArrayList<String> directors,
            ArrayList<String> screenwriters, int episodeNumber
    ) {
        this.title = title;
        this.rating = rating;
        this.premierDate = premierDate;
        this.actors = actors;
        this.directors = directors;
        this.screenwriters = screenwriters;
        this.episodeNumber = episodeNumber;
    }


    @Override
    public String toString() {
        return "Episodes " + episodeNumber +
                " :\nEpisode title : " + title +
                "\nEpisode rating : " + rating +
                "\nEpisode premierDate : " + premierDate +
                "\nEpisode actors : " + actors +
                "\nEpisode directors : " + directors +
                "\nEpisode screenwriters : " + screenwriters;
    }
}
