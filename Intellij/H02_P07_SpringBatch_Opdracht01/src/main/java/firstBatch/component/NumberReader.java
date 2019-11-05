package firstBatch.component;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class NumberReader implements ItemReader<String> {
    private String[] lines = {"1","2","3","4","5","6","7","8","9","10"};
    private int index = -1;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        String s = null;
        if(++index< lines.length){
            s = lines[index];
        }
        System.out.println("Read : " + s);
        return s;
    }
}
