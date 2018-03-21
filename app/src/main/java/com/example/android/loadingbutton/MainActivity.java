package com.example.android.loadingbutton;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class MainActivity extends AppCompatActivity
{
    CircularProgressButton cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpb = (CircularProgressButton) findViewById(R.id.load);

        cpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask<String,String,String> demo = new AsyncTask<String, String, String>() {
                    @Override
                    protected String doInBackground(String... voids) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "Done";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        if(s.equals("Done")) {
                            Toast.makeText(MainActivity.this, "Loading Done", Toast.LENGTH_SHORT).show();
                            cpb.doneLoadingAnimation(Color.parseColor("#452642"), BitmapFactory.decodeResource(getResources(),R.drawable.ic_done_white_48dp));
                        }
                    }
                };
                cpb.startAnimation();
                demo.execute();
            }
        });
    }
}
