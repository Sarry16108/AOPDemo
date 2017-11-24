package com.example.finance.aspectj.permission;

import android.util.Log;

import com.example.finance.aspectj.base.BaseAspect;
import com.example.finance.aspectj.tool.GlobalData;
import com.example.finance.aspectj.tool.ToolTip;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description:权限管理不是系统的功能权限，而是app中自己使用的权限控制管理
 *      比如：调用A方法前，user的状态，身份判断等。
 * Creator: Yanghj
 * Email: yanghj11@163.com
 * Date: 2017/11/10
 */
@Aspect
public class PermissionAspect extends BaseAspect {

    @Pointcut("execution(@RequestPermission * *..*.*(..)) && @annotation(permission)")
    public void executionPermissionRequirePointcut(RequestPermission permission) {

    }

    @Around("executionPermissionRequirePointcut(permission)")
    public Object executionPermissionRequire(ProceedingJoinPoint joinPoint, RequestPermission permission) throws Throwable {
        Log.e(TAG, "权限检测");
        if (1 != GlobalData.INSTANCE.getUser().getType()) {
            ToolTip.show("权限不够");
            return null;
        }

        return joinPoint.proceed();
    }

}
