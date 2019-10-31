package firstBatch.app;

import firstBatch.component.HelloProcessor;
import firstBatch.component.HelloReader;
import firstBatch.component.HelloWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "firstBatch")
@EnableBatchProcessing
public class HelloBatchApplication {

    @Autowired
    private JobBuilderFactory jobBuilder;

    @Autowired
    private StepBuilderFactory stepBuilder;
    
    @Bean
    protected Step helloStep(HelloReader reader,
                             HelloProcessor processor,
                             HelloWriter writer){
        return stepBuilder
                .get("helloStep")
                .<String, String> chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job helloJob(Step helloStep){
        return jobBuilder
                .get("helloJob")
                .start(helloStep)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloBatchApplication.class,args);
    }

}
