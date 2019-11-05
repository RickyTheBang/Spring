
package GET.component;


import GET.model.Message;
import GET.model.MessageList;
import org.springframework.http.ResponseEntity;

public interface MessagesClient {
    Message getMessageById(int id);

    MessageList getMessages();

    MessageList getMessagesByAuthor(String author);
}
