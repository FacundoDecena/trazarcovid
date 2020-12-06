package ar.com.degedev.trazar_covid.repository;

import ar.com.degedev.trazar_covid.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    @Query("SELECT r FROM Registro r")
    List<Registro> findAll();

    @Query("SELECT r FROM Registro r WHERE r.cliente.DNI = :clienteDNI")
    List<Registro> findRegistroByClienteDNI(@Param("clienteDNI") Integer clienteDNI);

    @Query("SELECT r FROM Registro r WHERE r.comercio.Id = :comercioId")
    List<Registro> findRegistroByComercioId(@Param("comercioId") Integer comercioId);

    @Query("SELECT r FROM Registro r WHERE r.fecha BETWEEN :desde AND :hasta")
    List<Registro> findRegistroByFechaBetween(@Param("desde") Date desde, @Param("hasta") Date hasta);

}
