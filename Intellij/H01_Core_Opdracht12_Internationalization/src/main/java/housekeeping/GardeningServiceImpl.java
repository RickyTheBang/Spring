package housekeeping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GardeningServiceImpl implements GardeningService, LunchListener, CoffeeListener{
	private GardeningTool tool;	
		
	@Autowired
	public void setGardeningTool(GardeningTool tool) {
		this.tool = tool;
	}
   
	@PostConstruct
	public void init() {
		System.out.println("GardenService preparing for work.");
	}

   @PreDestroy
   public void destroy() {
   	System.out.println("GardenService cleaning up.");
   }
	
	@EventListener
	public void onLunchEvent(LunchEvent e) {
		System.out.println("Taking a break for lunch");
	}

	@EventListener
	public void onCoffeeEvent(CoffeeEvent e) {
		System.out.println("Taking a break for drinking coffee");
	}
	
	public void garden() {
   	System.out.println("Working in the garden.");
   	tool.doGardenJob();
   }
}
