package com.controller;

import com.domain.Message;
import com.domain.MessageContent;
import com.domain.Message_Repo;
import com.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

   MessageRepository messageRepository;

   @Autowired
   void setMessageRepository(MessageRepository messageRepository){
       this.messageRepository = messageRepository;
   }



    @GetMapping("/allMessages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messageList = messageRepository.getALLMessages ();

        return ResponseEntity.ok(messageList);

    }
/*
,
            consumes = {
            MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
 */
    @PostMapping(consumes = {
            MediaType.ALL_VALUE,
            MediaType.APPLICATION_JSON_UTF8_VALUE,
            MediaType.APPLICATION_XML_VALUE}, value = "/addMessage")
    public ResponseEntity<Message_Repo> postMessage(@RequestBody MessageContent content, HttpServletRequest request) {

      Message message = new Message (content.getContent());



        messageRepository.save (message);

          if(message.getId () ==0){
            return ResponseEntity.badRequest ().build ();
        }
        URI uri = URI.create (request.getRequestURL ()
                +"/" + message.getId ());
       return ResponseEntity.created (uri).build ();
       // return ResponseEntity.ok().build();

    }

}
