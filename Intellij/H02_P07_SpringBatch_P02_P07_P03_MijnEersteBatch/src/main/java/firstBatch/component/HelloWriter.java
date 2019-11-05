package firstBatch.component;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelloWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> lines) throws Exception {
        lines.forEach(System.out::println);
    }
}
