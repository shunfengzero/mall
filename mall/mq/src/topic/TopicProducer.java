package topic;


import common.Pool;

import javax.jms.*;

public class TopicProducer {

    public static void send() {
        Connection con = Pool.createCon();

        try {
            con.start();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("second");
            MessageProducer producer = session.createProducer(topic);
            TextMessage message = session.createTextMessage("风萧萧兮易水寒2");
            producer.send(message);
            session.close();
            con.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        send();
    }

}
