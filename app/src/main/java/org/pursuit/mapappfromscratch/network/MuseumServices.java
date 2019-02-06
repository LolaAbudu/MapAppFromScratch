package org.pursuit.mapappfromscratch.network;

import org.pursuit.mapappfromscratch.model.MuseumsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumServices {

    @GET("JDVila/storybook/master/museums.json")
    Call<MuseumsList> getMuseum();
}
