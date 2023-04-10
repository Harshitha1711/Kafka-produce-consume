package com.example.apchekafkaproducerdemo;

import com.example.apchekafkaproducerdemo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
   //KafkaTemplate<String,String> kafkaTemplate;
    KafkaTemplate<String,Book> kafkaTemplate;
    private static final String TOPIC = "NewTopic";

//    @GetMapping("/publish/{message}")
//    public String publishMessage(@PathVariable("message") final String message){
//
//        kafkaTemplate.send(TOPIC,message);
//        return "Message is published";
//    }
    @PostMapping ("/publish")
    public String publishMessage(@RequestBody Book book){

        kafkaTemplate.send(TOPIC,book);
        return "Message is published";
    }

}
