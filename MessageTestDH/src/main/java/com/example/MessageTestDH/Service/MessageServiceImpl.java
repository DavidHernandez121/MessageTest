package com.example.MessageTestDH.Service;

import com.example.MessageTestDH.MessageDTO.MessageDTO;
import com.example.MessageTestDH.MessageDTO.MessageMapper;
import com.example.MessageTestDH.Model.Message;
import com.example.MessageTestDH.Repository.Repository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final Repository repository;
    private final MessageMapper messageMapper;

    @Override
    public  ResponseEntity getMessage(Map<String, List<MessageDTO>> messages) {

        List<MessageDTO> deviceMessages = messages.get("devices");
        if(deviceMessages == null || deviceMessages.isEmpty()){
            final String responseMsg = "Devices messages not found";
            return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
        }

        List<String> interceptedMessage = new ArrayList<>();
        int firstWordIndex = 0;

        for (final MessageDTO messageDTO : deviceMessages) {
            final List<String> words = messageDTO.getMessage();
            for(int i=0; i<words.size(); i++){
                final String word = words.get(words.size()-1-i).trim();

                if(interceptedMessage.size() <= i){
                    if(word.isEmpty()){
                        firstWordIndex++;
                    }else{
                        firstWordIndex=0;
                    }
                    interceptedMessage.add(0, word);
                    continue;
                }
                final int currentInterceptedWordIndex = interceptedMessage.size()-1-i;
                if(interceptedMessage.get(currentInterceptedWordIndex).isEmpty() && !word.isEmpty()){
                    if(currentInterceptedWordIndex < firstWordIndex){
                        firstWordIndex = currentInterceptedWordIndex;
                    }
                    interceptedMessage.set(currentInterceptedWordIndex, word);
                    continue;
                }

                if(!word.isEmpty() && !word.equalsIgnoreCase(interceptedMessage.get(currentInterceptedWordIndex))){
                    final String responseMsg = "We can't determine the message, the devices have different words for certain position";
                    return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
                }
            }
        }

        if(firstWordIndex >= interceptedMessage.size()){
            final String responseMsg = "We can't determine the message, the entire message is empty";
            return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
        }

        interceptedMessage = interceptedMessage.subList(firstWordIndex, interceptedMessage.size());
        if(interceptedMessage.stream().anyMatch(String::isEmpty)){
            final String responseMsg = "We can't determine the message. All devices have an empty word at certain position";
            return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
        }

        Map<String, String> response = new HashMap<>();
        response.put("Message", String.join(" ", interceptedMessage));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveMessage(Long id, MessageDTO messageDTO) {
        messageDTO.setId(id);
        Message message = messageMapper.dtoToEntity(messageDTO);
        return new ResponseEntity(messageMapper.entityToDto(repository.save(message)), HttpStatus.OK);
    }

    @Override
    public  ResponseEntity getSplitMessages (){
        List<Message> messages = repository.findAll();
        Map<String, List<MessageDTO>> messageDTOMap = new HashMap<>();
        messageDTOMap.put("devices", messageMapper.entityListToDTOList(messages));
        return getMessage(messageDTOMap);
    }

    @Override
    public  ResponseEntity getAllSplitMessages () {
        List<MessageDTO> response = messageMapper.entityListToDTOList(repository.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
