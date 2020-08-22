package com.dazzul.doitmission07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 고객 관리
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent("고객 관리");
            }
        });
        // 매출 관리
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent("매출 관리");
            }
        });

        // 상품 관리
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent("상품 관리");
            }
        });
    }

    protected void setIntent(String menu) {
        Intent intent = new Intent();
        intent.putExtra("menu", menu);
        setResult(RESULT_OK, intent);
        finish();
    }
}