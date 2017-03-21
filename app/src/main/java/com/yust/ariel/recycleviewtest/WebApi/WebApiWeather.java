package com.yust.ariel.recycleviewtest.WebApi;

import com.google.gson.annotations.Expose;

/**
 * Created by Ariel Yust on 05-Mar-17.
 */

public class WebApiWeather {

    @Expose
    long dt;
    @Expose
    float pressure;
    @Expose
    int humidity;
    @Expose
    float speed;
    @Expose
    int deg;
    @Expose
    int clouds;
    @Expose
    float rain;

    public long getDt() {
        return dt;
    }

    public float getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public int getClouds() {
        return clouds;
    }

    public float getRain() {
        return rain;
    }

    public WebApiWeather(long dt, float pressure, int humidity, float speed, int deg, int clouds, float rain) {
        this.dt = dt;
        this.pressure = pressure;
        this.humidity = humidity;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.rain = rain;
    }

    /*

    "dt":1488704400,
    "temp":{
            "day":3.75,
            "min":2.04,
            "max":3.75,
            "night":2.04,
            "eve":3.11,
            "morn":3.75
        },
    "pressure":1003.29,
    "humidity":96,
    "weather":[
        {
            "id":501,
            "main":"Rain",
            "description":"moderate rain",
            "icon":"10d"
        }
    ],
    "speed":5.71,
    "deg":227,
    "clouds":92,
    "rain":5.05

     */

}
