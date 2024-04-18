package com.example.MessageTestDH.MessageDTO;

import com.example.MessageTestDH.Model.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-18T14:32:10-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message dtoToEntity(MessageDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( dto.getId() );
        List<String> list = dto.getMessage();
        if ( list != null ) {
            message.setMessage( new ArrayList<String>( list ) );
        }

        return message;
    }

    @Override
    public MessageDTO entityToDto(Message entity) {
        if ( entity == null ) {
            return null;
        }

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setId( entity.getId() );
        List<String> list = entity.getMessage();
        if ( list != null ) {
            messageDTO.setMessage( new ArrayList<String>( list ) );
        }

        return messageDTO;
    }
}
