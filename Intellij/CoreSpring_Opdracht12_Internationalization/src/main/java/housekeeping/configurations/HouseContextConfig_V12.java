package housekeeping.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("housekeeping.*")
@PropertySource ("classpath:application.properties")
public class HouseContextConfig_V12 {


}
