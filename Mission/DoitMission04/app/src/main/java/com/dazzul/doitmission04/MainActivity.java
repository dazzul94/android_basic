package com.dazzul.doitmission04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        editText.addTextChangedListener(new TextWatcher() {

            //변경되기전 문자열을 담고있다.
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            //텍스트가 변경될때 마다 호출된다.
            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                //editText에 포커스가 되어있을 때
                if(editText.isFocusable()) {
                    try {
                        number = editText.getText().length();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                    //80이 넘을 경우 80으로 변경
                    if (number > 80) {
                        number = 80;
                    }
                    textView.setText(number + " / 80 바이트");
                }
            }

            //텍스트가 변경된 이후에 호출.
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 전송버튼에 onclick 이벤트를 넣는다.
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToastMessage(v);
            }
        });
    }

    private void showToastMessage(View v) {
        String contents =  editText.getText().toString();
        Toast.makeText(this, "전송 버튼이 눌렸어요. \n" + contents, Toast.LENGTH_LONG).show();
    }
}