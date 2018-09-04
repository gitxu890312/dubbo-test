package com.sinochem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sinochem.model.User;


@SpringBootApplication
@RestController
public class ConsumerApplication {

	@Reference(version = "1.0.0",loadbalance="roundrobin"/*,registry="zookeeper://10.26.6.160:2181", url = "dubbo://localhost:20880"*/)
  	private HelloService demoService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@GetMapping("/dubbo/test")
	public String hello() {
		String sayHello = demoService.sayHello("world");
		return sayHello;
	}
	
	@GetMapping("/dubbo/user")
	public String user() {
		User user = demoService.getUser();
		return user.toString();
	}
}
