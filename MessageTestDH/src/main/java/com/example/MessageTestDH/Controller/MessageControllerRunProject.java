package com.example.MessageTestDH.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MessageControllerRunProject {

    @GetMapping
    public String runProject(){
        return "The Project is running";
    }
}
