package firstBatch.app;

import firstBatch.component.HelloException;
import firstBatch.component.HelloProcessor;
import firstBatch.component.HelloReader;
import firstBatch.component.HelloWriter;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

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
                             HelloWriter writer) {
        return stepBuilder
                .get("helloStep")
                .<String, String>chunk(2)
                .faultTolerant()
                .retry(HelloException.class)
                .retryLimit(5)
                /*    .skip(HelloException.class)
                   .skipLimit(2) */
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job helloJob(Step helloStep) {
        return jobBuilder
                .get("helloJob")
                .start(helloStep)
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(HelloBatchApplication.class, args);
        Job job = ctx.getBean("helloJob", Job.class);
        JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);

        Map<String, JobParameter> params = new HashMap<>();
        params.put("number", new JobParameter(1L, true));
        params.put("comment", new JobParameter("First Job"));

        JobParameters jobParameters = new JobParameters(params);


        JobExecution jobExecution = jobLauncher.run(job, jobParameters);

    }

}
