package soapProjectClient;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import soapproject.web.HelloServiceEndpoint;

import java.net.MalformedURLException;
import java.net.URL;


@SpringBootApplication
public class AppConfig {
    @Bean
    public JaxWsPortProxyFactoryBean hello()
            throws MalformedURLException {
        JaxWsPortProxyFactoryBean proxy =
                new JaxWsPortProxyFactoryBean();
      proxy.setServiceInterface(HelloServiceEndpoint.class);
        proxy.setWsdlDocumentUrl(
                new URL("http://localhost/HelloService?wsdl"));
        proxy.setNamespaceUri(
                "http://web.soapProject/");
        proxy.setServiceName("HelloService");
        proxy.setPortName("HelloServiceEndpointPort");
        return proxy;

    }


}


