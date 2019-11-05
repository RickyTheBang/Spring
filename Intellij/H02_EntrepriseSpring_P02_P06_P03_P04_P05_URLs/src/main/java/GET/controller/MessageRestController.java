package GET.controller;

import GET.model.Message;
import GET.repository.MessageRepository;
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

    @RequestMapping(value = "{id:^\\d+$}/author",
    method = RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
public ResponseEntity<String> getMessage(
        @PathVariable("id") int id){
        System.out.println("GET Message");
        Message message = messageRepository.getMessageById(id);
        if(message !=null){
            return new ResponseEntity(message.getAuthor(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
