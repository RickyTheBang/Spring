/*
package RestAPI.controller;

import RestAPI.domain.Message_Repo;
import RestAPI.domain.Message;
import RestAPI.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
   @Autowired
    MessageRepository messageRepository;

  */
/*  @GetMapping("/allMessage")
    public ResponseEntity getAllMessages()
     return ResponseEntity.ok(new Message_Repo ("Hello World",55));
    }*//*

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> postSomething() {
        List<Message> messageList = messageRepository.getALLMessages ();

        return ResponseEntity.ok(messageList);

    }
   @GetMapping("/paramdemo")
   public ResponseEntity doSomethingWithParameter(@RequestParam(name = "test",required = false,defaultValue = "haha") String testParam){
       return ResponseEntity.ok(testParam);

   }

    @GetMapping("/something/{id}")
    public ResponseEntity doSomething(@PathVariable("id") Integer id) {

        System.out.println (id);
      //  service.getSomethingById(id);
        if(id ==55){
            return ResponseEntity.ok(new Message_Repo ("Hello World",55));
        }
       else {
           return ResponseEntity.status (HttpStatus.NOT_FOUND)
                   .body("Your resource was not found");
        }

    }

    @GetMapping("/something")
    public ResponseEntity doSomething() {

        // return new ResponseEntity<> (new Message("Hello World",7),HttpStatus.ACCEPTED);

      // return ResponseEntity.ok (new Message ("Hello World", 8));
        return ResponseEntity.ok(new Message_Repo ("Hello World",55));

    }


  */
/*     @PostMapping("/something")
    public ResponseEntity<Message> postSomething() {

        return ResponseEntity.ok(new Message ("Hello World",11));

    }*//*


    @PostMapping("/something")
    public ResponseEntity<Message_Repo> postSomething(@RequestBody Message_Repo messageRepo) {

        return ResponseEntity.ok().build ();

    }

}*/
