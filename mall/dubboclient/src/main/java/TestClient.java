import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.FirstService;

/**
 * Created by Administrator on 2017/12/12.
 */
public class TestClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("client.xml");
        FirstService fs = (FirstService) ctx.getBean("fs");
        System.out.println(fs.sum(3,4));

    }
}
