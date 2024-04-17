package com.example.MessageTestDH.Service;

import com.example.MessageTestDH.Model.Message;
import com.example.MessageTestDH.Repository.Repository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final Repository repository;

    @Override
    public  ResponseEntity getMessage(Map<String, List<Message>> message) {

        Map<String, String> returnedMap = new HashMap<>();
        List<Message> devicesList1 = new ArrayList<>();
        List<String> listaFinal = new ArrayList<>();
        devicesList1 = message.get("devices");
        HttpStatus httpStatus = HttpStatus.OK;

        if(devicesList1.isEmpty()){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }else{
            for (Message mapa : devicesList1) {
                List<String> strings = mapa.getMessage();
                for(int i=0; i<strings.size(); i++){
                    String palabra = strings.get(i);
                    if(i<= listaFinal.size()-1){
                        if(palabra.equals("")){
                            continue;
                        }else{
                            if(!listaFinal.get(i).equals("")){
                                if( !listaFinal.get(i).equalsIgnoreCase(palabra)){
                                    listaFinal.set(i, "");
                                    httpStatus = HttpStatus.BAD_REQUEST;
                                }
                            }else{
                                listaFinal.set(i, palabra);
                            }
                        }
                    }else {
                        listaFinal.add(palabra);
                    }

                }
            }
        }

        if(listaFinal.stream().allMatch(String::isEmpty) || listaFinal.contains("")){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        returnedMap.put("Message", String.join(" ", listaFinal));

        return new ResponseEntity<>(returnedMap, httpStatus);
    }

    @Override
    public Message saveMessage(Long id, Message message) {
        message.setId(id);
        return repository.save(message);
    }

    @Override
    public  ResponseEntity getMessage (){
        List<Message> messages = repository.findAll();
        Map<String, List<Message>> messageMap = new HashMap<>();
        messageMap.put("devices", messages);
        return getMessage(messageMap);
    }

    @Override
    public  List<Message> getMessages () {
        return repository.findAll();
    }
}
