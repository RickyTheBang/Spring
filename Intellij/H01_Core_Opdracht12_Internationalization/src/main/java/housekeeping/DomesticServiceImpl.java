package housekeeping;

import java.util.Locale;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("domesticService")
@Order
public class DomesticServiceImpl implements DomesticService {
	private CleaningService cleaningService;
	private GardeningService gardeningService;

	@Autowired
	private MessageSource ms;
	
	@Value("#{T(java.util.Locale).getDefault()}")

	private Locale locale;
	
	public void setMessageSource(MessageSource ms) {
		this.ms = ms;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Autowired
	public void setCleaningService(CleaningService cleaningService) {
		this.cleaningService = cleaningService;
	}

	@Autowired
	public void setGardeningService(@Qualifier("gardeningServiceImpl") GardeningService gardeningService) {
		this.gardeningService = gardeningService;
	}
	
	@PostConstruct
	public void init() {
		System.out.println(ms.getMessage("domestic.init", null, locale));
	}

   @PreDestroy
   public void destroy() {
		System.out.println(ms.getMessage("domestic.close", null, locale));
   }

	public void runHousehold() {

		System.out.println(ms.getMessage("domestic.job", null, locale));
		cleaningService.clean();
		gardeningService.garden();
	}
	
}
