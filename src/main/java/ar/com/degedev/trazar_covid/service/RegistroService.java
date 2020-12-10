package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.Registro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface RegistroService {

    Registro createRegistro(Registro registro);

    List<Registro> getAll();

    List<Registro> getRegistrosByClienteDNI(Integer dni);

    List<Registro> getRegistrosByComercioId(Integer comercioId);

    List<Registro> getRegistrosBetweenDates(LocalDateTime desde, LocalDateTime hasta);

}
