package firstBatch.component;

import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;

@Component
public class HelloReader implements ItemReader<String>, ItemStream {
    private static final String INDEX = "HelloReader.index";
    private String[] lines = {"Homer","Marge","Bart","Lisa","Maggy"};
    private int index = -1;

    @Override
    public String read() throws Exception{
        String s = null;
        if(++index< lines.length){
            s = lines[index];
            if(index++ ==4){
        //   throw new HelloException();
               /* try{
                    throw new HelloException();
                }catch (HelloException e){
                    index++;
                }*/

            }
        }
        System.out.println("Read : " + s);
        return s;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        index = executionContext.getInt(INDEX,-1);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.putInt(INDEX,index);
    }

    @Override
    public void close() throws ItemStreamException {

    }
}
