package com.sinochem;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.sinochem.model.User;

//@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    //	@Value("${dubbo.protocol.port}")
    private String port;

    @Override
    public String sayHello(String name) {
        System.out.println("接口被调用:"+name);
        return "Hello, " + name + ", " + new Date();
    }

    @Override
    public User getUser() {
        User u = new User();
        u.setAge(20);
        u.setUserName("zhangsan");
        return u;
    }

}