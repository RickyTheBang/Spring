package JMS.app;


import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SendMessage {
	public static void main(String[] args) throws Exception {

		ConnectionFactory factory = null;
		Connection con = null;
		Session session = null;
		MessageProducer sender = null;
		Destination queue = null;
		TextMessage message = null;

		try{
			Context ctx = new InitialContext();
			factory =(ConnectionFactory) ctx
					.lookup("ConnectionFactory");
			queue = (Destination) ctx.lookup("HelloQueue");
			con = factory.createConnection();
			session = con.createSession(false,
					Session.CLIENT_ACKNOWLEDGE);
			sender = session.createProducer(queue);
			message = session.createTextMessage();
			message.setText("Here is Berlin");
			sender.send(message);;
			System.out.println("Message sent to queue");

		}
		finally {
			if(sender!=null) sender.close();
			if(session!=null) session.close();
			if(con!=null) con.close();

		}

		 
	}
	

}

