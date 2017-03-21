package com.yust.ariel.recycleviewtest.WebApi;

import com.google.gson.annotations.Expose;

/**
 * Created by Ariel Yust on 05-Mar-17.
 */

public class WebApiCity {

    @Expose
    int id;
    @Expose
    String name;
    @Expose
    String country;
    @Expose
    int population;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public WebApiCity(int id, String name, String country, int population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.population = population;
    }
}
