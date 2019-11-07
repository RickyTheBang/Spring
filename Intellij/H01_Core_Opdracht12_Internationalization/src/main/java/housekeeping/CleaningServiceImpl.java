package housekeeping;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
@Profile("smallHouse")
public class CleaningServiceImpl implements CleaningService, LunchListener{
	private CleaningTool tool;
	private float rate;

	public CleaningServiceImpl() {
		System.out.println("CleaningServiceImpl: constructor");
	}

	@Autowired
	public void setCleaningTool(CleaningTool tool) {
		this.tool = tool;
	}

	@Value("${rate}")
	public void setRate(float rate) {
		this.rate = rate;
	}

	@PostConstruct
	public void init() {
		System.out.println("CleaningService preparing for work.");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("CleaningService cleaning up.");
	}

	@EventListener
	public void onLunchEvent(LunchEvent e) {
		System.out.println("Taking a break for lunch");
	}
	
	public void clean() {
		System.out.println("Cleaning the house");
		tool.doCleanJob();
	}
}
