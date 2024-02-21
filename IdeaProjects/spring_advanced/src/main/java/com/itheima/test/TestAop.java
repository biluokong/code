package com.itheima.test;

import org.springframework.stereotype.Component;

@Component
public class TestAop {
    public UserRegisteredEvent acceptEvent() {
        return new UserRegisteredEvent("why");
    }
}
