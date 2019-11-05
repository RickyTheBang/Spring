package beers;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages ={"beers"})
@EnableTransactionManagement
public class AppConfig {



}
