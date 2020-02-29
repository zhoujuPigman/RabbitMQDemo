package cn.huanji.Demo.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个生产工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置服务地址
        factory.setHost("127.0.0.1");

        //设置端口
        factory.setPort(5672);

        //设置用户名
        factory.setUsername("huanji");

        //设置密码
        factory.setPassword("3773");

        //设置仓库
        factory.setVirtualHost("/huanji");

        return factory.newConnection();

    }
}
