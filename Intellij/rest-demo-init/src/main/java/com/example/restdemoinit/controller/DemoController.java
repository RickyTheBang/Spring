package com.example.restdemoinit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    //@RequestMapping(value = "/something", method = RequestMethod.GET) // by default GET method
    // @GetMapping("/something") // afkorting van de vorige annotatie


    @GetMapping("/getByUser/{name}")
    public ResponseEntity getUsersByName(@PathVariable("name") String name,
                                         @RequestParam(required = false, name = "sorting")
    @RequestBody Message message){
        return ResponseEntity.ok(new Message ("Hello World",22));
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
            return ResponseEntity.ok(new Message ("Hello World",55));
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
        return ResponseEntity.ok(new Message ("Hello World",55));

    }


  /*     @PostMapping("/something")
    public ResponseEntity<Message> postSomething() {

        return ResponseEntity.ok(new Message ("Hello World",11));

    }*/

    @PostMapping("/something")
    public ResponseEntity<Message> postSomething(@RequestBody Message message) {

        return ResponseEntity.ok().build ();

    }

}