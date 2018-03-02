package queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueConsumer {

    public static void receive() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();

        try {
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("first");
            //消费者
            MessageConsumer consumer = session.createConsumer(queue);
            //注册监听器
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage msg = (TextMessage) message;

                    try {
                        System.out.println("收到:" + msg.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        receive();
    }
}
