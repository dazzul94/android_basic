package com.dazzul.samplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // 레이아웃 매니저 설정(기본적인 형태 - 세로방향으로)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        // 어댑터 설정
        PersonAdapter adapter = new PersonAdapter();

        adapter.addItem(new Person("김다솔1", "010-1234-1234"));
        adapter.addItem(new Person("김다솔2", "010-1234-1235"));
        adapter.addItem(new Person("김다솔3", "010-1234-1236"));
        adapter.addItem(new Person("김다솔1", "010-1234-1234"));
        adapter.addItem(new Person("김다솔2", "010-1234-1235"));
        adapter.addItem(new Person("김다솔3", "010-1234-1236"));
        adapter.addItem(new Person("김다솔1", "010-1234-1234"));
        adapter.addItem(new Person("김다솔2", "010-1234-1235"));
        adapter.addItem(new Person("김다솔3", "010-1234-1236"));
        adapter.addItem(new Person("김다솔1", "010-1234-1234"));
        adapter.addItem(new Person("김다솔2", "010-1234-1235"));
        adapter.addItem(new Person("김다솔3", "010-1234-1236"));
        adapter.addItem(new Person("김다솔1", "010-1234-1234"));
        adapter.addItem(new Person("김다솔2", "010-1234-1235"));
        adapter.addItem(new Person("김다솔3", "010-1234-1236"));
        adapter.addItem(new Person("김다솔1", "010-1234-1234"));
        adapter.addItem(new Person("김다솔2", "010-1234-1235"));
        adapter.addItem(new Person("김다솔3", "010-1234-1236"));

        recyclerView.setAdapter(adapter);
    }
}