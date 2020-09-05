package com.dazzul.doitmission12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dazzul.doitmission12.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = editText.getText().toString();

                // 인텐트에 부가정보 담기
                Intent intent = new Intent(getApplicationContext(), com.dazzul.doitmission12.MyService.class);
                intent.putExtra("inputText", inputText);

                // 서비스 시작하기
                startService(intent);
            }
        });
    }

    // 액티비티가 이미 만들어져있을 경우 새로운 인텐트 처리하기.
    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String inputText = intent.getStringExtra("inputText");
            Log.d(TAG, "processIntent: " + inputText);
            textView.setText(inputText);
//            Toast.makeText(this, "command : " + command + ", name : " + name, Toast.LENGTH_SHORT).show();
        }
    }
}