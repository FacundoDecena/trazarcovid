package ar.com.degedev.trazar_covid.repository;

import ar.com.degedev.trazar_covid.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    List<Cliente> findByApellido(@Param("apellido") String apellido);

}
