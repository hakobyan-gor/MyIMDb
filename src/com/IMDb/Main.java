package com.IMDb;

import com.IMDb.movie.Movie;
import com.IMDb.user.Admin;
import com.IMDb.user.RegularUser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        /*RegularUser regularUser = new RegularUser();
        regularUser.signUp("Gor","Gor");
        regularUser.signUp("Gor","Gor");
        regularUser.signIn("Gor","Gor");
        regularUser.signIn("Gor","?Gor");*/

        /*RegularUser regularUser = new RegularUser();
        regularUser.signUp("Admin2000","admin2000");*/

        /*RegularUser regularUser = new RegularUser();
        regularUser.signUp("GorGor", "Gor");*/


        /*Admin admin = new Admin();
        admin.signIn("Admin2000","admin2000");*/

        HashMap<String, String> actors = new HashMap<>();
        actors.put("Крис Эванс","Капитан Америка");
        actors.put("Крис Пратт","Звездный Лорд");
        actors.put("Крис Хемсфорд","Тор");

        ArrayList<String> directors = new ArrayList<>();
        directors.add("Джо Руссо");
        directors.add("Энтони Руссо");

        ArrayList<String> screenwriters = new ArrayList<>();
        screenwriters.add("Christopher Markus");
        screenwriters.add("Stephen McFeely");

        Movie movie = new Movie();
        Movie avengers = new Movie("Avengers : Age of Ultron",
                "About superheros.",
                "Fantastic", LocalDate.of(2019, Month.SEPTEMBER,1),
                actors,directors,screenwriters);
        movie.addMovie(avengers);

    }

}