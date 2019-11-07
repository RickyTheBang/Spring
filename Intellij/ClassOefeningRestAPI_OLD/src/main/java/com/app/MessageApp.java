/*
package RestAPI.app;

import RestAPI.AppConfig;
import RestAPI.domain.Message;
import RestAPI.domain_Beer.Beer;
import RestAPI.repository.MessageRepository;
import RestAPI.repository_Beer.BeerRepository;
import com.mysql.cj.protocol.MessageReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;


@SpringBootApplication
public class MessageApp {
    public static void main(String[] args) {

       ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        MessageRepository mr = ctx.getBean("messageRepository", MessageRepository.class);
        */
/*BeerService bs = ctx.getBean("beerService", BeerService.class);
        Beer beer01  = br.getBeerById(14);
        System.out.println("before order");
        System.out.println(beer01);
        bs.orderBeer("Order 10",14,7);
        System.out.println("after order");
        Beer beer02  = br.getBeerById(14);
        System.out.println(beer02);
        BeerOrderRepository bor = ctx.getBean("beerOrderRepository", BeerOrderRepository.class);
        BeerOrder beerOrder = bor.getBeerOrderById(6);
        System.out.println(beerOrder);*//*


        mr.save (new Message ("Hi"));
        List<Message> messages = mr.getALLMessages ();

        for(Message m : messages){
            System.out.println(m);
        }
    }
}

*/
