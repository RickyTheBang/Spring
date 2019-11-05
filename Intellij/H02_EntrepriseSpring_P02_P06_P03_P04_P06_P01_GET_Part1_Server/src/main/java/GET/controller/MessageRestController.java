package GET.controller;

import GET.model.Message;
import GET.model.MessageList;
import GET.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageRestController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value="{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Message> getMessage(@PathVariable("id") int id){
        Message message = messageRepository.getMessageById (id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MessageList> getMessages() {
        List<Message> messages = messageRepository.getAllMessages();
        MessageList messageList = new MessageList(messages);
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }
    @GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_XML_VALUE},
    params = {"author"})
    public ResponseEntity<MessageList> getMessagesForAuthor(@RequestParam("author") String author) {

        List<Message> messages = messageRepository.getAllMessagesByAuthor (author);
        MessageList messageList = new MessageList(messages);
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

}
