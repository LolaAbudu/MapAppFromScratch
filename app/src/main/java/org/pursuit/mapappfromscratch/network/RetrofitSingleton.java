package org.pursuit.mapappfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static Retrofit myOneInstance;

    public static Retrofit getInstance(){
        if(myOneInstance != null){
              return  myOneInstance;
        }
        myOneInstance = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://raw.githubusercontent.com/")
                .build();
        return myOneInstance;
    }

    private RetrofitSingleton() { }
}
