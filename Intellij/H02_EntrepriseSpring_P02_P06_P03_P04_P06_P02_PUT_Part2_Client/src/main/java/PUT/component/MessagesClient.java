
package PUT.component;


import PUT.model.Message;
import PUT.model.MessageList;

import java.net.URI;

public interface MessagesClient {
    Message getMessageById(int id);
    MessageList getMessages();
    MessageList getMessagesByAuthor(String author);
    URI createMessage(Message message);
}
