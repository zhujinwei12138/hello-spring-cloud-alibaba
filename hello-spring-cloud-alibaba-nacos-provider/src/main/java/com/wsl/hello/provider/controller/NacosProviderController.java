package com.wsl.hello.provider.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {
    @Value("${server.port}")
    private String port;

    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;



    // 从上下文中读取配置
    @GetMapping(value = "/hi")
    public String sayHi() {
        System.out.println("zhujinwei");
        return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
    }
    @GetMapping(value = "/test/{message}")
    public String test(@PathVariable String message) {
        System.out.println("123456789");
        return "Hello Nacos Discovery " + message + " i am from port " + port;
    }


}

