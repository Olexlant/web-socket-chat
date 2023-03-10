package com.example.websocketchat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    public Greeting messageGreeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(message.getName() + ": "+message.getContent());
    }
}
