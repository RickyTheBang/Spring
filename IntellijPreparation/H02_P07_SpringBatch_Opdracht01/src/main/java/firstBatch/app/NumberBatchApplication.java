package firstBatch.app;

import firstBatch.component.NumberProcessor;
import firstBatch.component.NumberReader;
import firstBatch.component.NumberWriter;
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
public class NumberBatchApplication {

    @Autowired
    private JobBuilderFactory jobBuilder;

    @Autowired
    private StepBuilderFactory stepBuilder;
    
    @Bean
    protected Step numberStep(NumberReader reader,
                              NumberProcessor processor,
                              NumberWriter writer){
        return stepBuilder
                .get("numberStep")
                .<String, String> chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job numberJob(Step numberStep){
        return jobBuilder
                .get("numberJob")
                .start(numberStep)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(NumberBatchApplication.class,args);
    }

}
