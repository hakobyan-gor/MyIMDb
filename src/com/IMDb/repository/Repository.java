package com.IMDb.repository;

import java.io.*;

public class Repository<K, V extends Serializable> {

    private static final String KEY_VALUE_DIVIDER = " @010/gh010@ ";
    private static final String LINE_DIVIDER = "\n";

    public void writeDateInFile(K key, V movie, String filePath) {

        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(key.toString() + KEY_VALUE_DIVIDER + Serializer.serialize(movie) + LINE_DIVIDER);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public V readDataFromFile(K key, String filePath){

        V movie = null;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(key)){
                    String movieString = line.split(KEY_VALUE_DIVIDER)[1];
                    movie = (V) Serializer.deserialize(movieString);
                    bufferedReader.close();
                    fileReader.close();
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return movie;
    }

    public int getId() throws FileNotFoundException {
        int count;
        FileReader fileReader = new FileReader("src\\com\\IMDb\\movieAndTVSeriesData\\MovieData.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        count = (int) bufferedReader.lines().count();

        return count;
    }

}
