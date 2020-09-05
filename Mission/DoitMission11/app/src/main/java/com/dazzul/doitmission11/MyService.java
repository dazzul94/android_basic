package com.dazzul.doitmission11;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate 호출됨.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand 호출됨.");

        /*
         Service.START_STICKY
        * Service가 강제 종료되었을 경우 시스템이 다시 Service를 재시작 시켜 주지만
        * intent 값을 null로 초기화 시켜서 재시작 합니다.
        * Service 실행시 startService(Intent service) 메서드를 호출 하는데
        * onStartCommand(Intent intent, int flags, int startId) 메서드에 intent로 value를 넘겨 줄 수 있습니다.
        * 기존에 intent에 value값이 설정이 되있다고 하더라도
        * Service 재시작시 intent 값이 null로 초기화 되서 재시작 됩니다.*/
        if (intent == null) {
            return Service.START_STICKY;
        } else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent) {
        String inputText = intent.getStringExtra("inputText");

        Log.d(TAG, "입력한 값 : " + inputText);

//         왜 쉬지?
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {};
            Log.d(TAG, "Wating " + i + "seconds.");
        }

        Intent returnIntent = new Intent(getApplicationContext(), MainActivity.class);
        returnIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        returnIntent.putExtra("inputText", inputText);
        startActivity(returnIntent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
