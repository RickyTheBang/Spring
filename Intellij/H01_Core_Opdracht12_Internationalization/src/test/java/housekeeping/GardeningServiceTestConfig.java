package housekeeping;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class GardeningServiceTestConfig {
   @Bean
   public GardeningToolMock tool() {
      return new GardeningToolMock();
   }
   
   @Bean
   public GardeningService gardener() {
      GardeningServiceImpl cs = new GardeningServiceImpl();
      cs.setGardeningTool(tool());
      return cs;
   }
   
	@Bean
	public static PropertySourcesPlaceholderConfigurer propConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
