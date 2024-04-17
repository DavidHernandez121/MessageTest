package com.example.MessageTestDH.Service;

import com.example.MessageTestDH.Model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MessageService {
    ResponseEntity getMessage (Map<String, List<Message>> message);

    Message saveMessage (Long id, Message message);

    ResponseEntity getMessage ();

    List<Message> getMessages ();
}
