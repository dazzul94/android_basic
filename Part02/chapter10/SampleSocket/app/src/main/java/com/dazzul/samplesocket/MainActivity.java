package com.dazzul.samplesocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    TextView textView;
    TextView textView2;

    Handler handler = new Handler();
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String data = editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send(data);
                    }
                }).start();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startServer();
                    }
                }).start();
            }
        });
    }

    // 클라이언트 로그 찍기
    public void printClientLog(final String data) {
        Log.d(TAG, "printClientLog: " + data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(data + "\n");
            }
        });
    }

    // 서버 로그 찍기
    public void printServerLog(final String data) {
        Log.d(TAG, "printServerLog: " + data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView2.append(data + "\n");
            }
        });
    }

    // 클라이언트에서 요청보내기
    public void send(String data) {

        try {
            int portNumber = 52708;
            Socket socket = new Socket("localhost", portNumber);
            printClientLog("소켓 연결함");

            ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
            outstream.writeObject(data);
            outstream.flush();
            printClientLog("데이터 전송함.");

            ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
            printClientLog("서버로부터 받음: " + instream.readObject());
            socket.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 서버에서 요청받기
    public void startServer() {
        try {
            int portNumber = 52708;

            ServerSocket server = new ServerSocket(portNumber);
            printServerLog("서버 시작함: " + portNumber);

            while (true) {
                Socket socket = server.accept();
                InetAddress clientHost = socket.getLocalAddress();
                int clientPort = socket.getPort();
                printServerLog("클라이언트 연결됨. " + clientHost + " : " + clientPort);

                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                Object obj = instream.readObject();
                printServerLog("데이터 받음." + obj);

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject(obj + " from Server");
                outstream.flush();
                printServerLog("데이터 보냄.");
                socket.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}