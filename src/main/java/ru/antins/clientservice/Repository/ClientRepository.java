package ru.antins.clientservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antins.clientservice.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
