package soapProject;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;


@SpringBootApplication(scanBasePackages ="soapProject")
public class AppConfig {
    @Bean
    public SimpleJaxWsServiceExporter exporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost/");
        return exporter;
    }


}


