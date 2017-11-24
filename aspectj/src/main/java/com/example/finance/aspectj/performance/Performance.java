package com.example.finance.aspectj.performance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:
 * Creator: Yanghj
 * Email: yanghj11@163.com
 * Date: 2017/11/9
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Performance {
}
