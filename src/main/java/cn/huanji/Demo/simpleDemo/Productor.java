package cn.huanji.Demo.simpleDemo;

import cn.huanji.Demo.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Productor {

    private static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        //从连接中获取一个渠道
        Channel channel = connection.createChannel();

        //添加渠道
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //需要发送的消息
        String message = "hello simple";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        System.out.println("发送消息到队列中");
        channel.close();
        connection.close();

    }
}
