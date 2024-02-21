package com.itheima;

import com.itheima.test.TestAop;
import com.itheima.test.UserRegisteredEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAdvancedApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAdvancedApplication.class, args);

        context.publishEvent(new UserRegisteredEvent("hello"));
        TestAop testAop = context.getBean(TestAop.class);
        testAop.acceptEvent();
    }
}
