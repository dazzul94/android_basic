package com.dazzul.samplelifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_MENU_CODE = 101;

    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, REQUEST_MENU_CODE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "onStart 호춛됨.", Toast.LENGTH_LONG).show();
        println("onStart 호출됨.");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this, "onStop 호춛됨.", Toast.LENGTH_LONG).show();
        println("onStop 호출됨.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "onDestroy 호춛됨.", Toast.LENGTH_LONG).show();
        println("onDestroy 호출됨.");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "onPause 호춛됨.", Toast.LENGTH_LONG).show();
        println("onPause 호출됨.");

        saveState(); // 현재 입력상자에 입력된 데이터를 저장
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this, "onResume 호춛됨.", Toast.LENGTH_LONG).show();
        println("onResume 호출됨.");

        restoreState(); // 설정 정보에 저장된 데이터를 복원
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Log.d("Main", data);
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ( (pref != null) && (pref.contains("name")) ) {
            String name = pref.getString("name", "");
            nameInput.setText(name);
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", nameInput.getText().toString());
        editor.commit();
    }
    protected void clearState() {
        SharedPreferences pref = getSharedPreferences("pred", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}