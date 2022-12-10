package io.spotsie.tools.service.impl;

import javax.inject.Singleton;

import io.spotsie.tools.service.GreetingService;

@Singleton
public class GreetingServiceImpl implements GreetingService {

    @Override
    public void sayHello(String name) {
        System.out.printf("Hello %s, go go commando!\n", name);
    }
    
}
