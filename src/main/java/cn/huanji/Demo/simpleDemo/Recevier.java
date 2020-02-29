package cn.huanji.Demo.simpleDemo;

import cn.huanji.Demo.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recevier {

    private static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //获取渠道
        Channel channel = connection.createChannel();

        //队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //定义消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String messsage = new String(body,"utf8");
                System.out.println(messsage);
            }
        };

        //监听队列
        channel.basicConsume(QUEUE_NAME,defaultConsumer);

       /* channel.close();
        connection.close();*/

    }
}
