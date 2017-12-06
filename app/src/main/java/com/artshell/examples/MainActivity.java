package com.artshell.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.artshell.requestor.RxRequestor;

import io.reactivex.Flowable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxRequestor requestor = new RxRequestor.Builder().build();
        Flowable<String> post = requestor.post(String.class, "http://baidu.com");
    }
}
