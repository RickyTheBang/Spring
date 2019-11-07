package housekeeping;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class HouseApp {
	public static void main(String[] args) {		
		ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class);
		DomesticService service = ctx.getBean("domesticService",
		   DomesticService.class);

		service.runHousehold();
	}
}
