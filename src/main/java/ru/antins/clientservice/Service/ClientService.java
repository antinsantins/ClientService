package ru.antins.clientservice.Service;

import org.springframework.http.ResponseEntity;
import ru.antins.clientservice.Entity.Client;
import ru.antins.clientservice.Entity.Contact;

public interface ClientService {
    ResponseEntity<Object> save(Client client);
    ResponseEntity<Object> showAll();
    ResponseEntity<Object> findById(Long id);
    ResponseEntity<Object> addContact(Long clientId, Contact contact);
    ResponseEntity<Object> getContactsByClientId(Long clientId);
    ResponseEntity<Object> getContactsByType(Long clientId, String type);
}
