package com.example.MessageTestDH.Controller;

import com.example.MessageTestDH.MessageDTO.MessageDTO;
import com.example.MessageTestDH.Model.Message;
import com.example.MessageTestDH.Service.MessageService;
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
