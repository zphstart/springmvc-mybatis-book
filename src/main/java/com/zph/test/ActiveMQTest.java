package com.zph.test;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * @auther zph
 * @date 2022/10/2 - 11:20
 */
public class ActiveMQTest extends BaseJunit4Test {
    public static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";//MQ地址
    public static final String QUEUE_NAME = "queue1";//队列名称

    @Test
    public void test() throws JMSException {
        //获取MQ连接工厂，记得填自定义的地址！因为没有修改账号和密码，否则需要三参数构造
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
        System.out.println(activeMQConnectionFactory);
        //通过工厂获取连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //记得要启动连接啊！消费者没这个取不了啊！
        connection.start();
        //通过连接创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //通过会话创建连接
        Queue queue = session.createQueue(QUEUE_NAME);
        //通过会话创建队列型的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        for (int i = 1; i <= 3; i++) {
            //通过会话创建消息
            TextMessage textMessage = session.createTextMessage("msg-------" + i);
            //通过生产者发送消息
            messageProducer.send(textMessage);
        }
        //释放资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("发送信息完毕");

    }

}
