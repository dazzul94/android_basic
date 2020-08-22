package com.dazzul.doitmission08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int MENU_1 = 11;
    public static final int MENU_2 = 22;
    public static final int MENU_3 = 33;

    public static final int REQUEST_MENU_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 고객 관리
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMenu(MENU_1);
            }
        });

        // 매출 관리
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMenu(MENU_2);
            }
        });

        // 상품 관리
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMenu(MENU_3);
            }
        });
    }

    protected void goMenu(int menuCode) {
        Intent intent = null;

        if (menuCode == MENU_1) {
            intent = new Intent(getApplicationContext(), Menu1Activity.class);
        } else if (menuCode == MENU_2) {
            intent = new Intent(getApplicationContext(), Menu2Activity.class);
        } else if (menuCode == MENU_3) {
            intent = new Intent(getApplicationContext(), Menu3Activity.class);
        }

        if(intent != null) {
            startActivityForResult(intent, REQUEST_MENU_CODE);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_MENU_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String menuName = data.getStringExtra("menuName");
                Toast.makeText(this, menuName, Toast.LENGTH_SHORT).show();
            }
        }
    }
}