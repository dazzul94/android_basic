package com.dazzul.doitmission04_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    EditText inputMessage;
    TextView inputCount;
    Button sendButton;
    Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 입력창
        inputMessage = findViewById(R.id.inputMessage);
        inputCount = findViewById(R.id.inputCount);

        // 텍스트가 입력될때 지켜보는 객체
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence str, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                // 바이트 수를 계산해서 inputNumber에 뿌려준다.
                byte[] bytes = null;
                try {
                    bytes = str.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    inputCount.setText(strCount + " / 80바이트");
                } catch(UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable strEditable) {
                // 만약 80자가 넘는다면 editText의 글자를 지워준다.
                byte[] bytes = null;
                try {
                    bytes = strEditable.toString().getBytes("KSC5601");
                    if(bytes.length > 80) {
                        strEditable.delete(strEditable.length()-2, strEditable.length()-1);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        };
        // 입력창에 사용자가 텍스트를 입력하면 지켜보는 이벤트 추가
        inputMessage.addTextChangedListener(textWatcher);

        // 전송버튼 이벤트
        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"입력한 메시지: \n" + inputMessage.getText(), Toast.LENGTH_LONG).show();
            }
        });

        // 닫기버튼 이벤트
        closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}