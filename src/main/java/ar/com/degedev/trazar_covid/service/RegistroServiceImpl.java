package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.Registro;
import ar.com.degedev.trazar_covid.repository.RegistroRepository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    public List<Registro> getRegistrosBetweenDates(Date desde, Date hasta) {
        return registroRepository.findRegistroByFechaBetween(desde, hasta);
    }
}
