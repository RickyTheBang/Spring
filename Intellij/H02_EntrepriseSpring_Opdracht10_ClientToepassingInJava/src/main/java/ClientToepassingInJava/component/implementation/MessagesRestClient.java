package ClientToepassingInJava.component.implementation;

import ClientToepassingInJava.component.MessagesClient;
import ClientToepassingInJava.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
                .getForEntity(baseURL + "/messages/{id}",
                        Message.class, id);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {

        }
        return null;

    }
}
