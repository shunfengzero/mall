package queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueProducer {



    public static void send() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            //获取连接
            Connection connection = factory.createConnection();
            //创建会话
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //队列:存储消息的位置
            Queue queue = session.createQueue("first");
            //生产者
            MessageProducer producer = session.createProducer(queue);
            TextMessage msg = session.createTextMessage("叛逆的鲁路修");
            producer.send(msg);
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        send();
    }
}





























