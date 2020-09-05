package com.dazzul.samplepermission2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 모든 위험권한을 불러와서 확인요청
        AutoPermissions.Companion.loadAllPermissions(this, 101);
    }

    // 응답 결과 받기
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }

    // 거절되었을 때 호출
    @Override
    public void onDenied(int i, String[] permissions) {
        Toast.makeText(this, "permission denied : " + permissions.length, Toast.LENGTH_SHORT).show();
    }

    // 승인되었을 때 호출
    @Override
    public void onGranted(int i, String[] permissions) {
        Toast.makeText(this, "permission granted : " + permissions.length, Toast.LENGTH_SHORT).show();
    }
}