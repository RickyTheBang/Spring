package JMS.app;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ReceiveMessage {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = null;
        Connection con = null;
        Session session = null;
        MessageConsumer receiver = null;
        Destination queue = null;
        Message message = null;


        try {
            Context ctx = new InitialContext();
            factory = (ConnectionFactory) ctx
                    .lookup("ConnectionFactory");
            queue = (Destination) ctx.lookup("HelloQueue");
            con = factory.createConnection();
            session = con.createSession(false,
                    Session.CLIENT_ACKNOWLEDGE);
            receiver = session.createConsumer(queue);
            con.start();
            message = receiver.receive(1);
            if(message!=null && message instanceof TextMessage){
                System.out.println(((TextMessage)message).getText());
            }


        } finally {
            if (receiver != null) receiver.close();
            if (session != null) session.close();
            if (con != null) con.close();

        }
    }
}