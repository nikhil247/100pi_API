package com.firebase.nikhilmanali.a100pi_api.presenter;

import android.util.Log;
import android.view.View;

import com.firebase.nikhilmanali.a100pi_api.Model.Example;
import com.firebase.nikhilmanali.a100pi_api.Model.Result;
import com.firebase.nikhilmanali.a100pi_api.Retrofit.ApiClient;
import com.firebase.nikhilmanali.a100pi_api.Retrofit.urlInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nikhil Manali on 10/31/2018.
 */

public class presenterPi {


    List<Result> list;
    public presenterPi(){

    }



    public void feeds(){
        list=new ArrayList<>();
        urlInterface apiService= ApiClient.getClient().create(urlInterface.class);
        Call<Example> call = apiService.getJson(); // call the Json data of the given page
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
              list=response.body().getResult(); // getting response from api and server


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });


    }



}
