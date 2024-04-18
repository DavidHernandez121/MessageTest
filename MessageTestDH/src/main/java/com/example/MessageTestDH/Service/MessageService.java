package com.example.MessageTestDH.Service;

import com.example.MessageTestDH.MessageDTO.MessageDTO;
import com.example.MessageTestDH.Model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface MessageService {
    ResponseEntity getMessage (Map<String, List<MessageDTO>> message);

    ResponseEntity saveMessage (Long id, MessageDTO message);

    ResponseEntity getSplitMessages ();

    ResponseEntity getAllSplitMessages ();
}
