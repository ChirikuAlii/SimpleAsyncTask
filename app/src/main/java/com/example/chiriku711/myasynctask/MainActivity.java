package com.example.chiriku711.myasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String DEMOS_ASYNC = "DemoAsync";
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tv_status);
        DemoAsync demoAsync = new DemoAsync();
        demoAsync.execute("Halo ini demo AsyncTask");


    }


private class DemoAsync extends AsyncTask<String,Void,String>{


        //status awal
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvStatus.setText("status: onPreExecute");
    }


    //yang dilakukan di background
    @Override
    protected String doInBackground(String... strings) {

        Log.d(DEMOS_ASYNC,"status : do InBackground");
        try {
            Thread.sleep(5000);

        }
        catch (Exception e){
            Log.d(DEMOS_ASYNC,e.getMessage());
        }

        return strings[0];
        }


        //hasilnya
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvStatus.setText ("status: onPostExecute: "+s);
    }
    }

}

