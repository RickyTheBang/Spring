package P02_P06_P03_P04_P05_URLs.repository;

import P02_P06_P03_P04_P05_URLs.model.Message;

import java.util.List;

public interface MessageRepository {

    public Message getMessageById(int id);
    public List<Message> getAllMessages();
    public List<Message> getAllMessagesByAuthor(String author);
    public Message createMessage(Message message);
    public Message updateMessage(Message message);
    public void deleteMessage(int id);
}
