package com.example.MessageTestDH.MessageDTO;

import com.example.MessageTestDH.Model.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message dtoToEntity(MessageDTO dto);

    MessageDTO entityToDto(Message entity);
}
