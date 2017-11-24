package com.example.finance.aspectj.tool;

import android.widget.Toast;

import com.example.finance.aspectj.base.BaseApplication;

/**
 * Description:
 * Creator: Yanghj
 * Email: yanghj11@163.com
 * Date: 2017/11/15
 */

public class ToolTip {

    public static void show(String tip) {
        Toast.makeText(BaseApplication.getContext(), tip, Toast.LENGTH_LONG).show();
    }
}
