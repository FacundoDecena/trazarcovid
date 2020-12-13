package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.Registro;
import ar.com.degedev.trazar_covid.repository.RegistroRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Resource
    RegistroRepository registroRepository;

    @Override
    public Registro createRegistro(Registro registro) {
        return registroRepository.save(registro);
    }

    @Override
    public List<Registro> getAll() {
        return registroRepository.findAll();
    }

    @Override
    public List<Registro> getRegistrosByClienteDNI(Integer dni) {
        return registroRepository.findRegistroByClienteDNI(dni);
    }

    @Override
    public List<Registro> getRegistrosByComercioId(Integer comercioId) {
        return registroRepository.findRegistroByComercioId(comercioId);
    }

    @Override
    public List<Registro> getRegistrosBetweenDates(LocalDateTime desde, LocalDateTime hasta) {
        return registroRepository.findRegistroByFechaBetween(desde, hasta);
    }

    @Override
    public List<Registro> getRegistrosBetweenDatesAndComercioId(LocalDateTime desde, LocalDateTime hasta, Integer comercioId) {
        return registroRepository.findRegistrosByFechaBetweenAndComercioId(desde, hasta, comercioId);
    }
}
