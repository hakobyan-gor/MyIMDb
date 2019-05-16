package com.IMDb.user;

import com.IMDb.movie.Movie;

import java.io.*;

public class RegularUser implements Serializable{

    private static final String USERNAME_PASSWORD_DIVIDER = " @000/gh000 ";
    private static final String LINE_DIVIDER = "\n";
    private Movie movie = new Movie();

    public RegularUser() throws FileNotFoundException {
    }

    public void signIn(String username, String password) throws IOException {
        if (checkUsernameAndPassword(username, password)) {
            System.out.printf("You are just sign in !\nWelcome %s!", username);
        } else {
            System.out.println("Your username or password is incorrect!");
        }
    }

    public void signUp(String username, String password) throws IOException {
        if (checkUsername(username)) {
            System.out.printf("You are just sign in !\nWelcome %s!", username);
            FileWriter fileWriter = new FileWriter("src\\com\\IMDb\\userData\\RegularUserData.txt", true);
            fileWriter.write(username + USERNAME_PASSWORD_DIVIDER + password + LINE_DIVIDER);
            fileWriter.close();
        } else {
            System.out.println("Username already exists!");
        }
    }

    /*public void rateMovie(String title, int rating) throws IOException {
        Movie movie = new Movie();
        movie.rateMovie(title,rating);
    }*/

    private boolean checkUsername(String username) throws IOException {
        FileReader fileReader = new FileReader("src\\com\\IMDb\\userData\\RegularUserData.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.split(USERNAME_PASSWORD_DIVIDER)[0].equals(username)) {
                bufferedReader.close();
                fileReader.close();
                return false;
            }
        }
        bufferedReader.close();
        fileReader.close();

        fileReader = new FileReader("src\\com\\IMDb\\userData\\AdminData.txt");
        bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            if (line.split(USERNAME_PASSWORD_DIVIDER)[0].equals(username)) {
                bufferedReader.close();
                fileReader.close();
                return false;
            }
        }

        bufferedReader.close();
        fileReader.close();
        return true;
    }

    private boolean checkUsernameAndPassword(String username, String password) throws IOException {
        FileReader fileReader = new FileReader("src\\com\\IMDb\\userData\\RegularUserData.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line.split(USERNAME_PASSWORD_DIVIDER)[0]);
            System.out.println(line.split(USERNAME_PASSWORD_DIVIDER)[1]);
            if (line.split(USERNAME_PASSWORD_DIVIDER)[0].equals(username) && line.split(USERNAME_PASSWORD_DIVIDER)[1].equals(password)) {
                bufferedReader.close();
                fileReader.close();
                return true;
            }
        }
        bufferedReader.close();
        fileReader.close();
        return false;
    }

    public void searchMovie(String title) throws IOException{
        movie.searchMovie(title);
    }

}
