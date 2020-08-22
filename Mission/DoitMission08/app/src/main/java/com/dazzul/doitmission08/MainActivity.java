package com.dazzul.doitmission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputId;
    EditText inputPwd;

    public static final int REQUEST_MENU_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputId = findViewById(R.id.inputId);
        inputPwd = findViewById(R.id.inputPwd);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = inputId.getText().toString();
                String pwd = inputPwd.getText().toString();

                if (id.length() == 0 || pwd.length() == 0) {
                    Toast.makeText(MainActivity.this, "아이디와 패스워드를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, REQUEST_MENU_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            String menuName = data.getStringExtra("menuName");
            Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
        }
    }
}