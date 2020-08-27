package com.dazzul.samplefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    // 프래그먼트를 inflate(객체화하여 메모리에 올리고 뷰그룹 객체에 추가시켜 반환)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main, container, false);

        // 메인 프래그먼트의 버튼 클릭 이벤트
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 메인 액티비티 참조
                MainActivity activity = (MainActivity)getActivity();
                activity.onFragmentChanged(0);
            }
        });

        return rootView;
    }
}