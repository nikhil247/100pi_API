package com.firebase.nikhilmanali.a100pi_api.Retrofit;
import com.firebase.nikhilmanali.a100pi_api.Model.Example;
import com.firebase.nikhilmanali.a100pi_api.Model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface urlInterface {

    @GET("api/v1.1/public/getcurrencies")
    Call<Example> getJson();
}
