package com.yust.ariel.recycleviewtest.WebApi;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by Ariel Yust on 05-Mar-17.
 */

public class WebApiDailyForecast {

    @Expose
    WebApiCity city;
    @Expose
    String cod;
    @Expose
    float message;
    @Expose
    int cnt;
    @Expose
    List<WebApiWeather> list;

    public WebApiCity getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public float getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<WebApiWeather> getList() {
        return list;
    }

    public WebApiDailyForecast(WebApiCity city, String cod, float message, int cnt, List<WebApiWeather> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    /*

    "city":{
	"id":524901,
	"name":"Moscow",
	"coord":{
		"lon":37.6156,
		"lat":55.7522
		},
	"country":"RU",
	"population":0
	},
    "cod":"200",
    "message":0.1034469,
    "cnt":14,
    "list":[]

    */
}
