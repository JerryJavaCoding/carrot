import com.jerry.carrot.connector.Receiver;

import java.io.IOException;

/**
 *
 * @author Jerry
 * @date 2018/6/19 0019
 */
public class Bootstrap {
    public static void main(String[] args) throws IOException {
        Receiver receiver=new Receiver();
        receiver.receive();
    }
}
