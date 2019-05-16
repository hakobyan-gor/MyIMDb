package com.IMDb.user;

import com.IMDb.movie.Movie;

import java.io.*;
import java.util.ArrayList;

public class Admin implements Serializable{

    private static final String USERNAME_PASSWORD_DIVIDER = " @000/gh000 ";

    public Admin() throws FileNotFoundException {
    }

    public void signIn(String username, String password) throws IOException {
        if (checkUsernameAndPassword(username, password)) {
            System.out.println("You are just sign in !\nWelcome! " + username);
        } else {
            System.out.println("Your username or password is incorrect!");
        }
    }

    private boolean checkUsernameAndPassword(String username, String password) throws IOException {
        FileReader fileReader = new FileReader("src\\com\\IMDb\\userData\\AdminData.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
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


}

