package com.example.MessageTestDH.Repository;

import com.example.MessageTestDH.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Message, Long> {
}
