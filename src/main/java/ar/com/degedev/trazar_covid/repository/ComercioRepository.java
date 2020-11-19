package ar.com.degedev.trazar_covid.repository;

import ar.com.degedev.trazar_covid.entity.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Integer> {
}
