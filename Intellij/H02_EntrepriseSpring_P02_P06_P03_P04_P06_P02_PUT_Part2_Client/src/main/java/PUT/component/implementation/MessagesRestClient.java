package PUT.component.implementation;

import PUT.component.MessagesClient;
import PUT.model.Message;
import PUT.model.MessageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class MessagesRestClient implements MessagesClient {
    private String baseURL;
    private RestTemplate template;

    @Value("${baseURL}")
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    @Autowired
    public void setTemplate(RestTemplate template) {
        this.template = template;
    }


    @Override
    public Message getMessageById(int id) {

        ResponseEntity<Message> response = template
                .getForEntity (baseURL + "/messages/{id}",
                        Message.class, id);
        if (response.getStatusCode ( ) == HttpStatus.OK) {
            return response.getBody ( );
        } else {

        }
        return null;

    }

    @Override
    public MessageList getMessages() {
        ResponseEntity<MessageList> response = template
                .getForEntity (baseURL + "/messages", MessageList.class);
        if (response.getStatusCode ( ) == HttpStatus.OK) {
            return response.getBody ( );
        } else {
            return null;
        }
    }

    @Override
    public MessageList getMessagesByAuthor(String author) {
        ResponseEntity<MessageList> response = template
                .getForEntity (baseURL + "/messages?author={0}", MessageList.class, author);
        if (response.getStatusCode ( ) == HttpStatus.OK) {
            return response.getBody ( );
        } else {
            return null;
        }

    }

    @Override
    public URI createMessage(Message message)
    {
        return template.postForLocation (baseURL +"/messages",message);
    }
}

