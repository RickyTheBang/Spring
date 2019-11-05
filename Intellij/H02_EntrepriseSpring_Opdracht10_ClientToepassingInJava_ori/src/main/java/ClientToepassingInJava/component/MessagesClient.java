package ClientToepassingInJava.component;

import ClientToepassingInJava.model.Message;

public interface MessagesClient {
    Message getMessageById(int id);
}
