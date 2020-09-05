package com.dazzul.samplereceiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 모든 위험 권한을 자동 부여하도록 하는 메서드 호출하기
        AutoPermissions.Companion.loadAllPermissions(this, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }

    @Override
    public void onDenied(int i, String[] permission) {

        Toast.makeText(this, "permission denied : " + permission.length, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGranted(int i, String[] permission) {
        Toast.makeText(this, "permission granted : " + permission.length, Toast.LENGTH_SHORT).show();
    }
}