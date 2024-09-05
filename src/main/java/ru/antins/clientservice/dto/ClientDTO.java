package ru.antins.clientservice.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String firstName;
    private String secondName;
    private LocalDateTime createdAt;
    private LocalDateTime lastActiveAt;
    private List<ContactDTO> contacts;
}
