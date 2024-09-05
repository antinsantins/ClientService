package ru.antins.clientservice.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.antins.clientservice.Entity.Client;
import ru.antins.clientservice.Entity.Contact;
import ru.antins.clientservice.Exception.ClientNotFoundException;
import ru.antins.clientservice.Repository.ClientRepository;
import ru.antins.clientservice.Repository.ContactRepository;
import ru.antins.clientservice.Responce.ResponseHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    ClientRepository clientRepository;
    ContactRepository contactRepository;
    @Override
    public ResponseEntity<Object> save(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        client.setLastActiveAt(LocalDateTime.now());
        Client savedClient = clientRepository.save(client);
        return ResponseHandler.responseBuilder("Client created successfully", HttpStatus.CREATED, savedClient);
    }
    @Override
    public ResponseEntity<Object> showAll() {
        List<Client> clients = clientRepository.findAll();
        return ResponseHandler.responseBuilder("List of all clients", HttpStatus.OK, clients);
    }
    @Override
    public ResponseEntity<Object> findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return ResponseHandler.responseBuilder("Client found", HttpStatus.OK, client.get());
        } else {
            throw new ClientNotFoundException("Client with id " + id + " not found");
        }
    }
    @Override
    public ResponseEntity<Object> addContact(Long clientId, Contact contact) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            contact.setClient(client.get());
            Contact savedContact = contactRepository.save(contact);
            return ResponseHandler.responseBuilder("Contact added successfully", HttpStatus.CREATED, savedContact);
        } else {
            throw new ClientNotFoundException("Client with id " + clientId + " not found");
        }
    }
    @Override
    public ResponseEntity<Object> getContactsByClientId(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            List<Contact> contacts = contactRepository.findByClientId(clientId);
            return ResponseHandler.responseBuilder("List of contacts for client with id " + clientId, HttpStatus.OK, contacts);
        } else {
            throw new ClientNotFoundException("Client with id " + clientId + " not found");
        }
    }
    @Override
    public ResponseEntity<Object> getContactsByType(Long clientId, String type) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            List<Contact> contacts = contactRepository.findByClientIdAndType(clientId, type);
            return ResponseHandler.responseBuilder("List of contacts of type " + type + " for client with id " + clientId, HttpStatus.OK, contacts);
        } else {
            throw new ClientNotFoundException("Client with id " + clientId + " not found");
        }
    }
}
