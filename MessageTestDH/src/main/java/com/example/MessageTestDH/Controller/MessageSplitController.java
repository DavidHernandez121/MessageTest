package com.example.MessageTestDH.Controller;

import com.example.MessageTestDH.Model.Message;
import com.example.MessageTestDH.Service.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/message_split/")
@RequiredArgsConstructor
public class MessageSplitController {

    private final MessageServiceImpl messageService;

    @PostMapping("/{Id}")
    public ResponseEntity postSplitMessage(@PathVariable("Id") Long id, @RequestBody Message message){
        return new ResponseEntity<>(messageService.saveMessage(id, message), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getSplitMessage(){
        return messageService.getMessage();
    }

    @GetMapping("/all")
    public List<Message> getAllSplitMessage(){
        return messageService.getMessages();
    }
}
