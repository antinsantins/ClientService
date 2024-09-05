package ru.antins.clientservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antins.clientservice.Entity.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByClientId(Long clientId);
    List<Contact> findByClientIdAndType(Long clientId, String type);
}
