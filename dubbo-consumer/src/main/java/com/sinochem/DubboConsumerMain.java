package com.sinochem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author xuming
 * @date 2019/2/16
 * @Version v1.0.0
 */
public class DubboConsumerMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo/dubbo-consumer.xml");

        HelloService helloService =(HelloService) context.getBean("helloService");
        String value = helloService.sayHello("xuming");
        System.err.println(value);

        OrderService orderService = (OrderService)context.getBean("orderService");
        String result = orderService.doOrder("redis集群部署", 22.2);
        System.err.println(result);
    }
}
