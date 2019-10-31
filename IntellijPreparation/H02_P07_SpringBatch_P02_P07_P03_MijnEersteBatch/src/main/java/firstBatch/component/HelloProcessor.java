package firstBatch.component;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class HelloProcessor implements ItemProcessor<String,String> {
    @Override
    public String process(String item) throws Exception {
        return "Hello " + item;
    }
}
