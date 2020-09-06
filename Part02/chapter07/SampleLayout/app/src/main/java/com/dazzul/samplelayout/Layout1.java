package com.dazzul.samplelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout1 extends LinearLayout {

    ImageView imageView;
    TextView textView;
    TextView textView2;

    public Layout1(Context context) {
        super(context);
        init(context);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

        // 인플레이션 하면 -> xml파일에 설정된 요소를 가져올 수 있다.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1, this, true);

        // 인플레이션 시키고 나서임
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
    }


    // 이미지 설정
    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

    // 이름 설정
    public void setName(String name) {
        textView.setText(name);
    }

    // 전화번호 설정
    public void setMobile(String moblie) {
        textView2.setText(moblie);
    }
}
