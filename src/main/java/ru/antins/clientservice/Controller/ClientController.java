package ru.antins.clientservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antins.clientservice.Entity.Client;
import ru.antins.clientservice.Entity.Contact;
import ru.antins.clientservice.Service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    ClientService clientService;

    // 1. Добавление нового клиента
    @PostMapping
    public ResponseEntity<Object> createClient(@RequestBody Client client) {
        return clientService.save(client);
    }
    // 2. Добавление нового контакта клиента
    @PostMapping("/{clientId}/contacts")
    public ResponseEntity<Object> addContact(@PathVariable Long clientId, @RequestBody Contact contact) {
        return clientService.addContact(clientId, contact);
    }
    // 3. Получение списка клиентов
    @GetMapping("/clients")
    public ResponseEntity<Object> getAllClients() {
        return clientService.showAll();
    }
    // 4. Получение информации по заданному клиенту
    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable Long id) {
        return clientService.findById(id);
    }
    // 5. Получение списка контактов заданного клиента
    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<Object> getContactsByClientId(@PathVariable Long clientId) {
        return clientService.getContactsByClientId(clientId);
    }
    // 6. Получение списка контактов заданного типа заданного клиента
    @GetMapping("/{clientId}/contacts/{type}")
    public ResponseEntity<Object> getContactsByType(@PathVariable Long clientId, @PathVariable String type) {
        return clientService.getContactsByType(clientId, type);
    }
}
