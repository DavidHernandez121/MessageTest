package com.example.MessageTestDH.Controller;

import com.example.MessageTestDH.MessageDTO.MessageDTO;
import com.example.MessageTestDH.Service.MessageService;
import lombok.RequiredArgsConstructor;
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

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity postMessage(@RequestBody Map<String, List<MessageDTO>> message){
        return messageService.getMessage(message);
    }
}
