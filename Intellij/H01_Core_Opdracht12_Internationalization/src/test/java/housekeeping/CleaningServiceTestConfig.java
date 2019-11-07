package housekeeping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@EnableAutoConfiguration
public class CleaningServiceTestConfig {
   @Bean
   public CleaningToolMock mock() {
      return new CleaningToolMock();
   }
   
   @Bean
   public CleaningService testCleaner() {
      CleaningServiceImpl cs = new CleaningServiceImpl();
      cs.setCleaningTool(mock());
      return cs;
   }
}
