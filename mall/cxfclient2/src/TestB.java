import com.test.service.FirstServiceService;

public class TestB {

    public static void main(String[] args) {
        FirstServiceService x = new FirstServiceService();
        String y = x.getFirstServicePort().print();
        System.out.println(y);

    }
}
