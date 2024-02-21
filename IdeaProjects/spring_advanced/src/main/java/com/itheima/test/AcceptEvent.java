package com.itheima.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AcceptEvent {
    private static final Logger log = LoggerFactory.getLogger(AcceptEvent.class);

    @EventListener
    public void testEvent(UserRegisteredEvent event) {
        log.debug(event.toString());
    }


    @Pointcut("execution(public * com.itheima.test.TestAop.acceptEvent())")
    private void testAopEvent() {}

    @Around("testAopEvent()")
    public void after(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed = pjp.proceed();
        log.debug(proceed.toString());
    }
}
