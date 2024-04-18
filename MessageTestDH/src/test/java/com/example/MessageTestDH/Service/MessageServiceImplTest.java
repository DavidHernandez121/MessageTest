package com.example.MessageTestDH.Service;

import com.example.MessageTestDH.MessageDTO.MessageDTO;
import com.example.MessageTestDH.Model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class MessageServiceImplTest {

    @InjectMocks
    private MessageServiceImpl messageService;

    private Message message;

    MessageServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        message = new Message();
        message.setId(1L);
        message.setMessage(Arrays.asList("este","mensaje"));
    }

    @Test
    void getMessageOffset200code() {

        String filePath = "src/test/java/com/example/MessageTestDH/Service/Input/MessageServiceTestCases.json";

        Map<String,String> expectedResponse = new HashMap<>();
        expectedResponse.put("Message", "este es un mensaje secreto");

        ResponseEntity response = messageService.getMessage(readJson(filePath));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody(), expectedResponse);
    }

    @Test
    void getMessageWith200code() {

        String filePath = "src/test/java/com/example/MessageTestDH/Service/Input/MessageServiceTestWithOffset.json";

        Map<String,String> expectedResponse = new HashMap<>();
        expectedResponse.put("Message", "este es un mensaje secreto");

        ResponseEntity response = messageService.getMessage(readJson(filePath));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody(), expectedResponse);
    }

    @Test
    void getMessageWithEmptyMessage400code() {

        String filePath = "src/test/java/com/example/MessageTestDH/Service/Input/MessageServiceTestEmptyMessage.json";

        Map<String,String> expectedResponse = new HashMap<>();
        expectedResponse.put("Message", "We can't determine the message. All devices have an empty word at certain position");

        ResponseEntity response = messageService.getMessage(readJson(filePath));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody(), expectedResponse.get("Message"));
    }

    @Test
    void getMessageWithDifferentWord400code() {

        String filePath = "src/test/java/com/example/MessageTestDH/Service/Input/MessageServiceTestWithDifferentWord.json";
        Map<String, List<MessageDTO>> jsonMap = new HashMap<>();

        Map<String,String> expectedResponse = new HashMap<>();
        expectedResponse.put("Message", "We can't determine the message, the devices have different words for certain position");

        ResponseEntity response = messageService.getMessage(readJson(filePath));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(response.getBody(), expectedResponse.get("Message"));
    }

    private Map<String, List<MessageDTO>> readJson (String filePath){
        Map<String, List<MessageDTO>> jsonMap = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            TypeReference<HashMap<String, List<MessageDTO>>> typeRef = new TypeReference<>() {};
            jsonMap = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonMap;
    }
}