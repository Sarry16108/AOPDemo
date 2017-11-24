package com.example.finance.aspectj.performance;

import android.util.Log;

import com.example.finance.aspectj.base.BaseAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Description:
 * Creator: Yanghj
 * Email: yanghj11@163.com
 * Date: 2017/11/9
 */
@Aspect
public class PerformanceAspect extends BaseAspect{
    private final String TAG = "PerformanceAspect";

    @Pointcut("execution(@com.example.finance.aspectj.performance.Performance * *(..))")
    public void methodType() {

    }

    @Around("methodType()")
    public Object onPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        Log.e(TAG, getLog(proceedingJoinPoint, startTime));

        return object;
    }

    private String getLog(ProceedingJoinPoint proceedingJoinPoint, long startTime) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        StringBuilder builder = new StringBuilder(methodSignature.getDeclaringTypeName());
        builder.append(":").append(methodSignature.getName())
                .append("----》[").append(System.currentTimeMillis() - startTime).append("ms] (")
                .append(proceedingJoinPoint.getSourceLocation())
                .append(")");
        return builder.toString();
    }


}
