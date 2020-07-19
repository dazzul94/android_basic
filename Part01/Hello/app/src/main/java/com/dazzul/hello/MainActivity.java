package com.dazzul.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 시작점 역할을 하는 함수 onCreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 확인1버튼 메시지
    public void onButton1Clicked(View v) {
        Toast.makeText(this, "확인1 버튼이 눌렸어요", Toast.LENGTH_LONG).show();
    }

    // 네이버 접속하기
    public void onButton2Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }

    // 전화걸기
    public void onButton3Clicked(View v) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-0000-0000"));
        startActivity(myIntent);
    }
}