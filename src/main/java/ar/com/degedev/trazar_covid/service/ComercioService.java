package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.Comercio;

import java.util.List;

public interface ComercioService {

    List<Comercio> getComercios();

    Comercio getComercioById(Integer comercioId);

    Comercio createComercio(Comercio comercio);

    Comercio updateComercio(Integer comercioId, Comercio comercio);
}
