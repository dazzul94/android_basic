package com.dazzul.doitmission09;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class InputFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_input, container, false);

        // 프래그먼트의 버튼은 루트인 viewGroup을 찾아서 버튼을 findViewByID
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                이거 맞나? getActivity().getApplicationContext()? 왜 getActivity?
                Toast.makeText(getActivity().getApplicationContext(), "입력한 정보 띄우기", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}