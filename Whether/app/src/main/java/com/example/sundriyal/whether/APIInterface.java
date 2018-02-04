package com.example.sundriyal.whether;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by sundriyal on 3/2/18.
 */

public interface APIInterface {


    String wether_url = API.WETHER;


    @GET(API.LOCATION_KEY)
    Call<Model> getKey(@Query("apikey") String key, @Query("q") String latLong, @Query("language") String language, @Query("details") Boolean details, @Query("toplevel") Boolean toplevel);


    @GET
    Call< List<Model2> > getWether(@Url String url, @Query("apikey") String key, @Query("language") String language, @Query("details") Boolean details);
}
