package com.doraemon.base.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 生或死,注释上这个标识的,没有钥匙就是死
 * Created by zbs on 2017/6/30.
 */
//@Component
//@Aspect
//@Log4j
public class DOACertificate {

//    @Pointcut("@annotation(com.doraemon.base.security.DAO)")
//    public void pointcut(){}
//
//    @Before(value="pointcut()")
//    public void before(ProceedingJoinPoint pjp){
//        Object[] objects = pjp.getArgs();
//        if(objects != null)
//            log.info("入参为"+JSON.toJSON(objects));
////        if (objects != null && objects.length > 0 ) {
////            for(Object object : objects){
////                object = null;
////            }
////        }
//    }
//
//    @After(value="pointcut()")
//    public void after(ProceedingJoinPoint pjp){
//
//    }

}
