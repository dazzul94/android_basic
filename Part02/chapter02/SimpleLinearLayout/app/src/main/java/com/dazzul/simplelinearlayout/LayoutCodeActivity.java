package com.dazzul.simplelinearlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);


        // 버튼의 layout_width, layout_height
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        Button button1 = new Button(this);
        button1.setText("Button1");
        button1.setLayoutParams(params);

        Button button2 = new Button(this);
        button2.setText("Button2");
        button2.setLayoutParams(params);

        Button button3 = new Button(this);
        button3.setText("Button3");
        button3.setLayoutParams(params);

        mainLayout.addView(button1);
        mainLayout.addView(button2);
        mainLayout.addView(button3);

        setContentView(mainLayout);
    }
}