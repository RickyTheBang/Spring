package P02_P06_P03_P04_P05_URLs.controller;

import P02_P06_P03_P04_P05_URLs.model.Message;
import P02_P06_P03_P04_P05_URLs.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/**/messages")
public class MessageRestController {
    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(value = "{id}",
    method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
public ResponseEntity<Message> getMessage(
        @PathVariable("id") int id){
        System.out.println("GET Message");
        Message message = messageRepository.getMessageById(id);
        if(message !=null){
            return new ResponseEntity<>(message, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
