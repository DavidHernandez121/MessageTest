package com.example.MessageTestDH.MessageDTO;

import com.example.MessageTestDH.Model.Message;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message dtoToEntity(MessageDTO dto);

    MessageDTO entityToDto(Message entity);

    default List<MessageDTO> entityListToDTOList(List<Message> messages){
        List<MessageDTO> messagesDTO = new ArrayList<>();
        messages.forEach(message -> {
            messagesDTO.add(entityToDto(message));
        });
        return messagesDTO;
    }
}
