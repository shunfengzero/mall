import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2017/12/12.
 */
public class TestProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("producer.xml");
       ctx.start();
        System.out.println("服务端启动了");
        try {
            //等待输入---阻塞
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
