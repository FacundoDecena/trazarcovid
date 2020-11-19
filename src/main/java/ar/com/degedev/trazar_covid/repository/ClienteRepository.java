package ar.com.degedev.trazar_covid.repository;

import ar.com.degedev.trazar_covid.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
