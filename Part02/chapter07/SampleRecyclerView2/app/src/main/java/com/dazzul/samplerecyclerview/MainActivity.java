package com.dazzul.samplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // 그리드 레이아웃(두 칼럼으로 표시되는 격자 모양의 레이아웃
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);


        // 어댑터 설정
        adapter = new PersonAdapter();

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
        
        adapter.setOnItemClickListener(new OnpersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(MainActivity.this, "아이템 선택됨: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}