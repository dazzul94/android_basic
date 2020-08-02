package com.dazzul.doitmisson03_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView01;
    ImageView imageView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // onCreate 할때 모든 버튼과 이미지뷰를 할당해준다.
        imageView01 = findViewById(R.id.imageView01);
        imageView02 = findViewById(R.id.imageView02);
        Button button01 = findViewById(R.id.button01);
        Button button02 = findViewById(R.id.button02);

        // 버튼에 onclick 이벤트를 넣는다.
        button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveImageUp();
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveImageDown();
            }
        });

        moveImageUp();
    }

    private void moveImageUp() {
        imageView01.setImageResource(R.drawable.image01);
        imageView02.setImageResource(0);

        imageView01.invalidate(); //화면을 갱신한다.
        imageView02.invalidate(); //화면을 갱신한다.
    }

    private void moveImageDown() {
        imageView01.setImageResource(0);
        imageView02.setImageResource(R.drawable.image01);

        imageView01.invalidate(); //화면을 갱신한다.
        imageView02.invalidate(); //화면을 갱신한다.
    }
}