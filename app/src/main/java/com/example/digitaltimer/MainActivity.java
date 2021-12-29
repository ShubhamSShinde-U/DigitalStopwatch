package com.example.digitaltimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

TextView textView;
boolean isRunning;  // It is Boolean variable used check whether stopwatch is running or not.
int second=0;       // Global variable for calculate seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.timer);

        setTitle("Digital Stopwatch");
        Timer();            //call to call function
    }

    public void starttimer(View view) {

        isRunning=true;         //Starttimer function is get called when start button is clicked
    }

    public void Stoptimer(View view) {

        isRunning=false;        //Stoptimer function is get called when stop button is clicked
    }

    public void resettimer(View view) {
        isRunning = false;      //resettimer function is get called when reset button is clicked
        second=0;
    }
    public void Timer(){
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int s= second%60;       //calculating seconds
                 int m =second/60;      //calculating minutes
                int h= m/60;            //calculating hours

                 if (isRunning){
                    second++;       //checking whether stopwatch is running , if yes then increment it by 1
                  }
                String formatString = String.format(Locale.getDefault(),"%02d:%02d:%02d",h,m,s);
                textView.setText(formatString);
                handler.postDelayed(this,1000);     //printing results after 1 seconds
            }
        };
        handler.post(runnable);
    }


    public void attribute(View view) {
        Intent i = new Intent(getApplicationContext(),attribute.class);     // Giving intent to attribute activity
        startActivity(i);
    }
}