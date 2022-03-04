package com.bosco.dummyrest.aop;

import org.apache.tomcat.jni.Time;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Timer;

@Aspect
@Component
public class TimerAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimerAspect.class);

    @Around("@annotation(ExternalCallTimer)")
    public Object logRequestTime(ProceedingJoinPoint pjp) {
        Object value = null;

        long current = System.currentTimeMillis();

        try {
            value = pjp.proceed();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        long time = System.currentTimeMillis() - current;
        logger.info(time + " ms");

        return value;
    }
}
