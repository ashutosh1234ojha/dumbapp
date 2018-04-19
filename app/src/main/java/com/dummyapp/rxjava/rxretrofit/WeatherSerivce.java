package com.dummyapp.rxjava.rxretrofit;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Ashutosh Ojha on 4/17/18.
 */

public interface WeatherSerivce {
    @GET("/api/v1/employee/1")
    Observable<WeatherData> getWeatherReport();
}
