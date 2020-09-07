package com.dazzul.samplethread3;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView textView;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });

        textView = findViewById(R.id.textView);
    }

    class BackgroundThread extends Thread {

        int value = 0;

        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {}

                value += 1;
                Log.d(TAG, "run: value : " + value);

                // post
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("value 값 : " + value);
                    }
                });

            }
        }
    }
}