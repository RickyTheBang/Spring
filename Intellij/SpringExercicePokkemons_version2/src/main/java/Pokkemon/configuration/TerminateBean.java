package Pokkemon.configuration;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class TerminateBean {


    @PreDestroy
    public void onDestroy() throws Exception {
        System.out.println("Spring Container is destroyed!");
    }
}
