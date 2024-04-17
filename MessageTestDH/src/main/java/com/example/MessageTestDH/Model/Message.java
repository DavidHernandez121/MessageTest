package com.example.MessageTestDH.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    private Long id;
    @ElementCollection
    @Column(nullable = false)
    private List<String> message;
}
