package firstBatch.component;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class NumberProcessor implements ItemProcessor<String,String> {

    @Override
    public String process(String s) throws Exception {
       Double result = Math.pow(Double.parseDouble(s),2.0);
        return result.toString();
    }
}
