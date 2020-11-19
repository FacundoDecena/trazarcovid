package ar.com.degedev.trazar_covid.repository;

import ar.com.degedev.trazar_covid.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
