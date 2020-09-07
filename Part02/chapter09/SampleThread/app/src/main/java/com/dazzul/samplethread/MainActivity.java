package com.dazzul.samplethread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    int value = 0;
    TextView textView;

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
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                  Thread.sleep(1000);

                } catch (Exception e) {}

                value += 1;
                Log.d(TAG, "run: value : " + value);

                // UI 객체에 직접 접근이 불가하다. -> 핸들러를 사용해야 한다.
                // textView.setText("value 값: " + value);
            }
        }
    }
}