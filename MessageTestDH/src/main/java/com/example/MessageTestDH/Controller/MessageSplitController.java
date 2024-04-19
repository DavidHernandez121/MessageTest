package com.example.MessageTestDH.Controller;

import com.example.MessageTestDH.MessageDTO.MessageDTO;
import com.example.MessageTestDH.Service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/message_split/")
@RequiredArgsConstructor
public class MessageSplitController {

    private final MessageService messageService;

    @PostMapping("/{id}")
    public ResponseEntity postSplitMessage(@PathVariable("id") Long id, @RequestBody MessageDTO message){
        return messageService.saveMessage(id, message);
    }

    @GetMapping
    public ResponseEntity getSplitMessages(){
        return messageService.getSplitMessages();
    }

    @GetMapping("/all")
    public ResponseEntity getAllSplitMessage(){
        return messageService.getAllSplitMessages();
    }
}
