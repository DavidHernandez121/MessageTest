package com.example.MessageTestDH.Controller;

import com.example.MessageTestDH.Model.Message;
import com.example.MessageTestDH.Service.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/message/")
@RequiredArgsConstructor
public class MessageController {

    private final MessageServiceImpl messageService;

    @PostMapping
    public ResponseEntity postMessage(@RequestBody Map<String, List<Message>> message){
        return messageService.getMessage(message);
    }
}
