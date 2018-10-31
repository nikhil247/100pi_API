package com.firebase.nikhilmanali.a100pi_api;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.firebase.nikhilmanali.a100pi_api.Model.Example;
import com.firebase.nikhilmanali.a100pi_api.Model.Result;
import com.firebase.nikhilmanali.a100pi_api.Retrofit.ApiClient;
import com.firebase.nikhilmanali.a100pi_api.Retrofit.urlInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


       mReceiver = new BroadcastReceiver() {
            public void onReceive (Context context, Intent intent) {
                String action = intent.getAction();

                init();
                if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
                    if(intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1) == BluetoothAdapter.STATE_ON){
                        getFeeds();

                    }

                }

            }

        };

    }

    public void init(){
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void getFeeds(){

        urlInterface apiService= ApiClient.getClient().create(urlInterface.class);
        Call<Example> call = apiService.getJson(); // call the Json data of the given page
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                List<Result> list=response.body().getResult();
                adapter=new Adapter(list);
                recyclerView.setAdapter(adapter);
                WriteToFile(list);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });


    }



    public void WriteToFile(List<Result> list) {
        // add-write text into file
        String fileName ="blah.txt";//like 2016_01_12.txt


        try
        {
            File root = new File(Environment.getExternalStorageDirectory()+File.separator+"Music_Folder", "Report Files");
            //File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists())
            {
                root.mkdirs();
            }
            File gpxfile = new File(root, fileName);
            FileWriter writer = new FileWriter(gpxfile,true);

            for(int i=0;i<list.size();i++){
                writer.append(list.get(i).getCurrency()+" "+ list.get(i).getCurrencyLong()+" "+list.get(i).getTxFee()+" \n");
            }
            writer.flush();
            writer.close();
            addNotification();
        }
        catch(IOException e)
        {
            e.printStackTrace();

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        this.registerReceiver(mReceiver, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
    }


    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.men)
                        .setContentTitle("100Pi")
                        .setContentText("Download Complete");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }


}
