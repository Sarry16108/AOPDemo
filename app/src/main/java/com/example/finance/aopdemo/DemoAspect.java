package com.example.finance.aopdemo;

import android.util.Log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;

@Aspect
public class DemoAspect {

    static final String TAG = "DemoAspect";

    @Pointcut("execution(* *..*.on*(..))")
    public void logForActivity() {
        Log.e(TAG, "logForActivity");
    }

    @Before("logForActivity()")
    public void log(JoinPoint joinPoint) {
        Log.e(TAG, joinPoint.toShortString());
    }

    @Pointcut("execution(@SecurityCheckAnnotation public * *..*.*(..)) && @annotation(ann)")
    public void checkPermssion(SecurityCheckAnnotation ann) {
    }

    @Before("checkPermssion(securityCheckAnnotation)")
    public void check(JoinPoint joinPoint, SecurityCheckAnnotation securityCheckAnnotation) {
        String neededPermission = securityCheckAnnotation.declaredPermission();
        Log.e(TAG, "\tneeded permission is " + neededPermission + "   point:" + joinPoint.getSourceLocation());
        SecurityCheckManager manager = SecurityCheckManager.getInstanc();
        if (manager.checkPermission(neededPermission) == false) {
//            throw new SecurityException("Need to declare permission:" + neededPermission);
            Log.e(TAG, "have no permission to read phone state");
        }
        return;
    }
}


