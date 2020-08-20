package com.dazzul.sampleorientation2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showToast("방향: ORIENTATION_LANDSCAPE");
        } else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            showToast("방향: ORIENTATION_PORTRAIT");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart 호춛됨.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy 호춛됨.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("onStop 호춛됨.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}