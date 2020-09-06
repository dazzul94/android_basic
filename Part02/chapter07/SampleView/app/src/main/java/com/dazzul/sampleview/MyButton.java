package com.dazzul.sampleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {

    private static final String TAG = "MyButton";

    public MyButton(@NonNull Context context) {
        super(context);
        init(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {

        // 뷰의 배경색과 텍스트 컬러 지정
        setBackgroundColor(Color.CYAN);
        setTextColor(Color.BLACK);

        // 뷰의 글자크기 지정
        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize);
    }

    // 뷰가 그려질 때 호출되는 함수에 기능 추가하기
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: 호출됨");
    }

    // 뷰가 터치될 때 호출되는 함수에 기능 추가하기
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: 호출됨");

        int action = event.getAction();
        switch (action) {

            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.RED);
                break;

            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.BLACK);
                break;
        }

        // 다시 그린다.
        invalidate();

        return true;
    }
}
