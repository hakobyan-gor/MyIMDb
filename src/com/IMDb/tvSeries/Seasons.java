package com.IMDb.tvSeries;

import java.io.Serializable;

public class Seasons implements Serializable {

    private int seasonNumber;

    Seasons(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @Override
    public String toString() {
        return "Season : " + seasonNumber + '}';
    }

}
