package com.example.finance.aopdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.finance.aspectj.DebugTrace;
import com.example.finance.aspectj.performance.Performance;
import com.example.finance.aspectj.permission.RequestPermission;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.toAOP).setOnClickListener(this);
        test();
        test1(1, 1);
        test2();
    }

    @Performance
    private void test() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d("MainActivity", "test()");
    }

    @RequestPermission(permissions = {"android.permission.INSTALL_LOCATION_PROVIDER",
                                        "android.permission.ACCESS_NETWORK_STATE",
                                        "android.permission.READ_CONTACTS"})
    private void test1(int t1, int t2) {
        Log.d("MainActivity", "test1()");
    }

    @DebugTrace
    public void test2() {
        Log.d("MainActivity", "test1()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toAOP:
                startActivity(new Intent(this, AopDemoActivity.class));
                break;
        }
    }
}
