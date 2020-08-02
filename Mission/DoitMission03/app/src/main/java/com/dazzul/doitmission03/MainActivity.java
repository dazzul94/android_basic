package com.dazzul.doitmission03;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView01;
    ScrollView scrollView02;

    ImageView imageView01;
    ImageView imageView02;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showImage01();
    }

    public void buttonImgUpClicked(View v) {
        showImage01();
    }

    public void buttonImgDownClicked(View v) {
        showImage02();
    }

    private void showImage01() {
        scrollView01 = findViewById(R.id.scrollView01);
        imageView01 = findViewById(R.id.imageView01);
        scrollView01.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView01.setImageDrawable(bitmap);
        imageView01.getLayoutParams().width = bitmapWidth;
        imageView01.getLayoutParams().height = bitmapHeight;

        imageView02 = findViewById(R.id.imageView02);
        imageView02.setImageResource(0);
    }

    private void showImage02() {
        scrollView02 = findViewById(R.id.scrollView02);
        imageView02 = findViewById(R.id.imageView02);
        scrollView02.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView02.setImageDrawable(bitmap);
        imageView02.getLayoutParams().width = bitmapWidth;
        imageView02.getLayoutParams().height = bitmapHeight;

        imageView01 = findViewById(R.id.imageView01);
        imageView01.setImageResource(0);
    }
}