package com.sinochem;

/**
 * @Author xuming
 * @date 2019/2/16
 * @Version v1.0.0
 * order 接口
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String doOrder(String name, Double price) {
        System.out.println("order execute");
        return "order" + name + price;
    }
}
