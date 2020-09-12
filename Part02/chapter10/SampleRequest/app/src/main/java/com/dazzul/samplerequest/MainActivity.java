package com.dazzul.samplerequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    static RequestQueue requestQueue;

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
                makeRequest();
            }
        });

        if (requestQueue == null) {
            // RequestQueue 객체 생성하기
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }

    private void makeRequest() {
        String url = editText.getText().toString();

        StringRequest request = new StringRequest(Request.Method.GET, url,
           // 응답받을 리스너 객체 생성
           new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                println("응답->" + response);
            }
            // 에러가 발생했을 때 호출될 리스너 객체 생성
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                println("에러->" + error.getMessage());
            }
        }) {
            // POST 방식을 사용하면서 요청 파라미터를 전달하고자 할때 HashMap에 담아준다.
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청보냄.");
    }

    public void println(String data){
        textView.append(data + "\n");
    }
}