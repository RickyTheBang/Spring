package com.example.restdemoinit.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping(value = "/something", method = RequestMethod.GET) // by default GET method
    // @GetMapping("/something") // afkorting van de vorige annotatie
    //public ResponseEntity<Message> doSomething(){
    //  public ResponseEntity doSomething(e) {

    @GetMapping("/something")
    public ResponseEntity doSomething() {

        // return new ResponseEntity<> (new Message("Hello World",7),HttpStatus.ACCEPTED);

      // return ResponseEntity.ok (new Message ("Hello World", 8));
        return ResponseEntity.ok(new Message ("Hello World",55));

    }


    @PostMapping("/something")
    public ResponseEntity postSomething(@RequestBody Message message) {
        System.out.println (message.toString () );
        // return new ResponseEntity<> (new Message("Hello World",7),HttpStatus.ACCEPTED);

        // return ResponseEntity.ok (new Message ("Hello World", 8));
        return ResponseEntity.ok().build ();

    }
}