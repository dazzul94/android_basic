package com.dazzul.doitmission08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu1Activity extends AppCompatActivity {

    public static final int REQUEST_LOGIN_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        // 메뉴 버튼
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("menuName", "고객 관리");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // 로그인 버튼
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("menuName", "고객 관리");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}