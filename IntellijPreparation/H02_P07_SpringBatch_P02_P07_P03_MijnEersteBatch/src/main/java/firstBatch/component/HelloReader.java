package firstBatch.component;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class HelloReader implements ItemReader<String> {
    private String[] lines = {"Homer","Marge","Bart","Lisa","Maggy"};
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
