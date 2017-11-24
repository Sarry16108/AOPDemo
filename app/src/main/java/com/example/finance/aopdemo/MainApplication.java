package com.example.finance.aopdemo;

import com.example.finance.aspectj.base.BaseApplication;
import com.example.finance.aspectj.tool.GlobalData;
import com.example.finance.aspectj.User;

public class MainApplication extends BaseApplication {


    @Override
    public void onCreate() {
        SecurityCheckManager.createInstance(this);
        super.onCreate();
        GlobalData.INSTANCE.setUser(new User("yang", 2));
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
